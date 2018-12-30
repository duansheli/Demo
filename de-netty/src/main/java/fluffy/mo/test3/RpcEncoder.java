package fluffy.mo.test3;

import fluffy.mo.SerializationUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class RpcEncoder extends MessageToByteEncoder {

  private Class<?> genericClass;

  public RpcEncoder(Class<?> genericClass) {
      this.genericClass = genericClass;
  }

  @Override
  public void encode(ChannelHandlerContext ctx, Object in, ByteBuf out) throws Exception {
      if (genericClass.isInstance(in)) {
          byte[] data = SerializationUtil.obj_To_Byte(in);
          out.writeInt(data.length);
          out.writeBytes(data);
      }
  }
}