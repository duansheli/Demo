package com.example.netty.test6;

import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

public class Test6_Server {

  public static final String HOST = System.getProperty("host", "127.0.0.1");
  public static final int PORT = Integer.parseInt(System.getProperty("port", "8009"));

  public static void main(String[] args) throws Exception {
    EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      ServerBootstrap b = new ServerBootstrap();
      b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO))
          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) {
              ch.pipeline()
              // 依次添加处理器
              .addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4))
              .addLast("frameEncoder", new LengthFieldPrepender(4, false))
              // 此处的处理器为对应上面的处理器修改了父类
              .addLast(new RpcDecoder())
              .addLast(new RpcEncoder())
              // 在3秒内没有写或读的操作时，触发超时
              .addLast(new IdleStateHandler(0, 0, 3, TimeUnit.SECONDS))
              .addLast(new HeartBeatServerHandler())
              
              ;
            }
          });

      // Bind and start to accept incoming connections.
      ChannelFuture f = b.bind(PORT).sync();

      System.out.println("server 启动成功");
      f.channel().closeFuture().sync();
      System.out.println("server 停止阻塞解除");
    } finally {
      workerGroup.shutdownGracefully();
      bossGroup.shutdownGracefully();
    }
  }
}
