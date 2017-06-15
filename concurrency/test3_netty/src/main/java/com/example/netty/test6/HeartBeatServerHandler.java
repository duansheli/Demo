package com.example.netty.test6;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class HeartBeatServerHandler extends ChannelInboundHandlerAdapter {

  private static final int TRY_TIMES = 3;

  private int currentTime = 0;

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    System.out.println("本服务器已与客户端断开连接");
  }

  @Override
  public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    System.out.println("触发超时");

    if (evt instanceof IdleStateEvent) {
      IdleStateEvent event = (IdleStateEvent) evt;
      if (event.state() == IdleState.ALL_IDLE) {
        System.out.println("触发 3秒未读或写消息");
        if (currentTime < TRY_TIMES) {
          currentTime++;
          System.out.println("当前未执行【读数据】超时次数  " + currentTime);

        } else {// 连续三次超时
          ctx.channel().close();
        }
      }
    }
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    currentTime = 0;// 重置计数器
    ctx.fireChannelRead(msg);
  }
}