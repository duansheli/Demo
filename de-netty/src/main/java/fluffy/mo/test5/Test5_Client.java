package fluffy.mo.test5;

import java.net.InetSocketAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import fluffy.mo.test5.core.RpcDecoder;
import fluffy.mo.test5.core.RpcEncoder;
import fluffy.mo.test5.service.HelloService;
import fluffy.mo.test5.service.Person;
import fluffy.mo.test5.service.ServiceUtil;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

public class Test5_Client {

  public static void main(String[] args) throws Exception {
    System.out.println("运行前线程数量 " + Thread.activeCount());
    // 1. 通过动态代理生成远程调用对象
    HelloService hs = ServiceUtil.create(HelloService.class);

//    if (true) {
//      System.out.println(hs);
//      return;
//    }
    Stopwatch all = Stopwatch.createStarted();
    Person p = new Person();
    p.setName("zs");
    p.setPwd("123");

    Stopwatch timeCost = Stopwatch.createStarted();
    // 2. 发起调用
    String pwd = hs.pwd(p);// 远程调用
    timeCost.stop();
    System.out.println("首次请求时间 " + timeCost.elapsed(TimeUnit.MILLISECONDS));

    for (int i = 0; i < 20; i++) {
      System.out.println("请求计数  " + i);

      timeCost = Stopwatch.createStarted();
      hs.pwd(p);// 调用服务
      timeCost.stop();
      System.out.println("本次请求时间 " + timeCost.elapsed(TimeUnit.MILLISECONDS));
      if (i % 5 == 0) { // 此处可发现每次请求后的线程没有被销毁 以至于线程越来越多 此问题如何解决？
        System.out.println(i + " 当前线程 数量 " + Thread.activeCount());
      }
    }
    // 3. 输出方法返回的结果
    System.out.println(" 远程调用结果为 " + pwd);
    System.out.println("返回结果后线程数量 " + Thread.activeCount());
    System.out.println("done  -------- " + all.elapsed(TimeUnit.MILLISECONDS));
  }

  public static class Sender {
    // 1. 线程池_监听器
    static ListeningExecutorService threadPoolExecutor = null;
    static Sender sender;
    private Lock msgLock = new ReentrantLock();
    private Condition connectStatus = msgLock.newCondition();
    Test5_ClientHandler messageSendHandler = null;
    static {
      TimeUnit unit = TimeUnit.MILLISECONDS;
      long keepAliveTime = 0;
      int maximumPoolSize = 16;
      int corePoolSize = 16;
      // 线程池的配置项 ： 队列 ， 线程命名， 添加任务的策略
      threadPoolExecutor = MoreExecutors.listeningDecorator(new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
          keepAliveTime, unit, new LinkedBlockingQueue<Runnable>()));
    }

    public static Sender getInstance() {
      if (sender == null) {
        synchronized (Sender.class) {
          if (sender == null) {
            sender = new Sender();
            sender.init();
          }
        }
      }
      return sender;
    }

    public Test5_ClientHandler getMessageSendHandler() throws InterruptedException {
      try {
        msgLock.lock();
        if (messageSendHandler == null) {
          connectStatus.await();
        }
        return messageSendHandler;
      } finally {
        msgLock.unlock();
      }
    }

    public void setMessageSendHandler(Test5_ClientHandler messageSendHandler) {
      try {
        msgLock.lock();
        this.messageSendHandler = messageSendHandler;
        connectStatus.signalAll();
      } finally {
        msgLock.unlock();
      }
    }

    private void init() {
      EventLoopGroup group = new NioEventLoopGroup();
      InetSocketAddress remoteAddr = new InetSocketAddress(Test5_Server.HOST, Test5_Server.PORT);
      ListenableFuture<Boolean> listenableFuture = threadPoolExecutor
          .submit(new MessageSendInitializeTask(group, remoteAddr));

      Futures.addCallback(listenableFuture, new FutureCallback<Boolean>() {
        public void onSuccess(Boolean result) {
//          try {
//            if (messageSendHandler == null) {
//              connectStatus.await();
//            }
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          }
          System.out.println(" 初始化客户端回调结果  " + result + messageSendHandler);
        }

        public void onFailure(Throwable t) {
          t.printStackTrace();
        }
      }, threadPoolExecutor);
    }

  }

  public static class MessageSendInitializeTask implements Callable<Boolean> {

    private EventLoopGroup eventLoopGroup = null;
    private InetSocketAddress serverAddress = null;

    MessageSendInitializeTask(EventLoopGroup eventLoopGroup, InetSocketAddress serverAddress) {
      this.eventLoopGroup = eventLoopGroup;
      this.serverAddress = serverAddress;
    }

    public Boolean call() {
      Bootstrap b = new Bootstrap();
      b.group(eventLoopGroup).channel(NioSocketChannel.class).option(ChannelOption.SO_KEEPALIVE, true);
      b.handler(new ChannelInitializer<SocketChannel>() {
        @Override
        public void initChannel(SocketChannel channel) throws Exception {
          channel.pipeline().addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4))
              .addLast("frameEncoder", new LengthFieldPrepender(4, false)).addLast(new RpcDecoder())
              .addLast(new RpcEncoder()) // 将 RPC 请求进行编码（为了发送请求）
              .addLast(new Test5_ClientHandler()); // 使用 RpcClient 发送 RPC 请求
        }
      });

      ChannelFuture channelFuture = b.connect(serverAddress);
      channelFuture.addListener(new ChannelFutureListener() {
        public void operationComplete(final ChannelFuture channelFuture) throws Exception {
          if (channelFuture.isSuccess()) {
            Test5_ClientHandler handler = channelFuture.channel().pipeline().get(Test5_ClientHandler.class);
            Sender.getInstance().setMessageSendHandler(handler);
          }
        }
      });
      return Boolean.TRUE;
    }
  }

}
