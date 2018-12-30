package com.example.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class Test1_ClientHandler extends SimpleChannelInboundHandler<Object> {

  private ByteBuf content;
  private ChannelHandlerContext ctx;

  @Override
  public void channelActive(ChannelHandlerContext ctx) {
    this.ctx = ctx;
    // 建立连接后立即想服务器发送数据
    ctx.writeAndFlush("hello server myName is cli");
    // 通过监听器循环发送
    generateTraffic();
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) {
    System.out.println("cli------ channelInactive");
    content.release();
  }

  @Override
  public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
    // Server is supposed to send nothing, but if it sends something, discard
    // it.
    System.out.println("cli------ channelRead0  " + msg);
    int i = 2;
    long l = System.currentTimeMillis();
    while ((System.currentTimeMillis() - l) < i * 1000) {

    }
    ctx.writeAndFlush("myName is cli----" + counter++);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    // Close the connection when an exception is raised.
    cause.printStackTrace();
    ctx.close();
  }

  long counter = 1;

  private void generateTraffic() {
    int i = 2;
    long l = System.currentTimeMillis();
    while ((System.currentTimeMillis() - l) < i * 1000) {

    }
    // 每次发送数据成功后，监听器会再次调用此方法
    String s = "cli_1-";
    String s1 = s + counter++;
    System.out.println("客户端发送数据 " + s1);
    ctx.writeAndFlush(s1).addListener(trafficGenerator);
  }

  private final ChannelFutureListener trafficGenerator = new ChannelFutureListener() {
    int i = 0;

    @Override
    public void operationComplete(ChannelFuture future) {
      if (future.isSuccess()) {
        generateTraffic();
      } else {
        future.cause().printStackTrace();
        future.channel().close();
      }
    }
  };
}
