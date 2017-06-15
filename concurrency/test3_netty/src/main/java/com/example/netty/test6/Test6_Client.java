package com.example.netty.test6;

import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;

public class Test6_Client {
  public static final String HOST = System.getProperty("host", "127.0.0.1");
  public static final int PORT = Integer.parseInt(System.getProperty("port", "8009"));

  public static void main(String[] args) {
    EventLoopGroup group = new NioEventLoopGroup();
    Bootstrap bootstrap = new Bootstrap();
    bootstrap.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
      @Override
      public void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline()
            .addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4))
            .addLast("frameEncoder", new LengthFieldPrepender(4, false))
            .addLast(new RpcDecoder())
            .addLast(new RpcEncoder())
            // 在4秒内没有写操作时，触发超时
            .addLast(new IdleStateHandler(0, 4, 0, TimeUnit.SECONDS))
            .addLast(new HeartBeatClientHandler());
      }
    });

    connect(bootstrap);
    System.out.println("-------------------------------------");
  }

  static int tryCount = 0;

  public static void connect(Bootstrap bootstrap) {
    ChannelFuture future = null;
    try {
      future = bootstrap.connect(HOST, PORT).sync();
      tryCount = 0;
      future.channel().closeFuture().sync();
      System.out.println("连接已断开  进入finally开始重连");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      if (null != future && future.channel() != null) {
        // 为何要这个关闭操作不太明白
        System.out.println("关闭资源");
        if (future.channel().isOpen()) {
          future.channel().close();
        }
      }
      if (tryCount < 3) {
        tryCount++;
        connect(bootstrap);
      } else {
        System.out.println("重连3次都已失败");
      }

    }

  }

}
