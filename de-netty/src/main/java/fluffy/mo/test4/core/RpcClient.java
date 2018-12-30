package fluffy.mo.test4.core;

import com.google.common.util.concurrent.Monitor;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

public class RpcClient extends SimpleChannelInboundHandler<RpcMessage> {
  static EventLoopGroup group = new NioEventLoopGroup();
  private String host;
  private int port;

  private RpcResponse response;

  private Monitor m = new Monitor();
  private final Monitor.Guard setResponse = new Monitor.Guard(m) {
    public boolean isSatisfied() {
      return response == null;
    }
  };
  private final Monitor.Guard waitResponse = new Monitor.Guard(m) {
    public boolean isSatisfied() {
      return response != null;
    }
  };

  public RpcClient(String host, int port) {
    this.host = host;
    this.port = port;
  }

  @Override
  public void channelRead0(ChannelHandlerContext ctx, RpcMessage msg) throws Exception {
    try {
      m.enterWhen(setResponse); // 收到消息，保存结果
      this.response = msg.getRpcRespose();
    } finally {
      m.leave();
    }
  }

  public RpcResponse send(RpcRequest request) throws Exception {

    try {
      Bootstrap bootstrap = new Bootstrap();
      bootstrap.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
        @Override
        public void initChannel(SocketChannel channel) throws Exception {
          channel.pipeline()
          .addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4))
          .addLast("frameEncoder", new LengthFieldPrepender(4, false))
          .addLast(new RpcDecoder())
          .addLast(new RpcEncoder()) // 将 RPC 请求进行编码（为了发送请求）
          .addLast(RpcClient.this); // 使用 RpcClient 发送 RPC 请求
        }
      })
      // .option(ChannelOption.SO_KEEPALIVE, true)
      ;

      ChannelFuture future = bootstrap.connect(host, port).sync();
      // 写入请求数据
      future.channel().writeAndFlush(request).sync();
      // 写入请求完成
      m.enterWhen(waitResponse); // 进入阻塞，等待结果返回

      future.channel().close();
      return response;
    } finally {
      m.leave();
      System.out.println("关闭请求连接");
    }
  }
}