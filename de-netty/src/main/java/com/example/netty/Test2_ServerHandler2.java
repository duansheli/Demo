package com.example.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class Test2_ServerHandler2 extends ChannelInboundHandlerAdapter {
  int i = 1;

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    print("0   channelActive " + i++);
    super.channelActive(ctx);
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    print("1   channelRead " + i++ , msg);
    ctx.writeAndFlush("myName is Server"+ i);

    // 如不调用此方法则消息不会进入下一个处理链
    super.channelRead(ctx, msg+"tag2");
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
  
  static void print(Object ... ss){
    StringBuilder s = new StringBuilder("ch--2--");
    for (Object string : ss) {
      s.append(string);
    }
    System.out.println(s.toString());
  }
}
