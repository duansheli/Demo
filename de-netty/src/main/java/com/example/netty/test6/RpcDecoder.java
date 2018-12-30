package com.example.netty.test6;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

public class RpcDecoder extends MessageToMessageDecoder<ByteBuf> {

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
    byte[] data = new byte[msg.readableBytes()];
    msg.readBytes(data);

    Object obj = RpcMessage.byte_to_obj(data);
    out.add(obj);
  }

}