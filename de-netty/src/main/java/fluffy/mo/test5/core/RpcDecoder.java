package fluffy.mo.test5.core;

import java.util.List;

import fluffy.mo.SerializationUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

public class RpcDecoder extends MessageToMessageDecoder<ByteBuf> {

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
    byte[] data = new byte[msg.readableBytes()];
    msg.readBytes(data);

    Object obj = SerializationUtil.byte_to_obj(data, RpcMessage.class);
    RpcMessage result = (RpcMessage) obj;

    out.add(obj);
  }

}
