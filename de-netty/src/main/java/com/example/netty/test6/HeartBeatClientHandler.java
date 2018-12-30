package com.example.netty.test6;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class HeartBeatClientHandler extends ChannelInboundHandlerAdapter {

  static ByteBuf buf;
  static {
    RpcMessage rm = new RpcMessage();
    rm.setHeartBeat(true);
    byte[] bs = RpcMessage.obj_To_Byte(rm);
    buf = Unpooled.copiedBuffer(bs);
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    System.out.println("本客户端已与服务器断开连接");
  }

  int sendCount = 1;

  @Override
  public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    System.out.println("触发超时");

    if (evt instanceof IdleStateEvent) {
      IdleStateEvent event = (IdleStateEvent) evt;
      if (event.state() == IdleState.WRITER_IDLE) {
        System.out.println("触发 4秒未写消息");
        ++sendCount;
        // 此时发送心跳, 模拟不稳定连接
        if ((sendCount % 3 == 0)) {
          ctx.channel().writeAndFlush(buf.copy());
        }
      }
    }
  }

}