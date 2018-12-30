package com.example.netty.test6;

import java.util.List;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

public class RpcEncoder extends MessageToMessageEncoder<Object>{

  @Override
  protected void encode(ChannelHandlerContext ctx, Object msg, List<Object> out) throws Exception {
    RpcMessage message = new RpcMessage();
    if (null != msg) {
      byte[] data = RpcMessage.obj_To_Byte(message);
      out.add(Unpooled.copiedBuffer(data));
    }
  }

  
}