package com.example.netty.test5.core;

import java.util.List;

import com.example.netty.SerializationUtil;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

public class RpcEncoder extends MessageToMessageEncoder<Object>{

  @Override
  protected void encode(ChannelHandlerContext ctx, Object msg, List<Object> out) throws Exception {
    if (null != msg) {
      byte[] data = SerializationUtil.obj_To_Byte(msg);
      out.add(Unpooled.copiedBuffer(data));
    }
  }

  
}