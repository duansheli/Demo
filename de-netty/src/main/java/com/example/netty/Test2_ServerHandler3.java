package com.example.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class Test2_ServerHandler3 extends ChannelInboundHandlerAdapter {
  int i = 1;

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    print("0   channelActive " + i++);
    super.channelActive(ctx);
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    print("1   channelRead " + i++ , msg);
    // 运行此方法表示将消息抛个下一个处理链
    // 作为最后一个处理链，运行此方法不会有下一个处理链处理此消息，此时日志会提示消息被丢弃
    // super.channelRead(ctx, msg);
  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    print("2   channelReadComplete " + i++);
    super.channelReadComplete(ctx);
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    print("3   channelInactive " + i++);
    super.channelInactive(ctx);
  }

  static void print(Object... ss) {
    StringBuilder s = new StringBuilder("ch--3--");
    for (Object string : ss) {
      s.append(string);
    }
    System.out.println(s.toString());
  }
}
