package fluffy.mo.test6;

import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

public class RpcMessage {
  boolean isHeartBeat;
  String name = "hello";

  public boolean isHeartBeat() {
    return isHeartBeat;
  }

  public void setHeartBeat(boolean isHeartBeat) {
    this.isHeartBeat = isHeartBeat;
  }

  // util
  private static Objenesis objenesis = new ObjenesisStd(true);
  static Class<RpcMessage> cls = RpcMessage.class;

  public static byte[] obj_To_Byte(RpcMessage obj) {
    LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
    try {
      Schema<RpcMessage> schema = RuntimeSchema.createFrom(cls);
      return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
    } catch (Exception e) {
      throw new IllegalStateException(e.getMessage(), e);
    } finally {
      buffer.clear();
    }
  }

  public static RpcMessage byte_to_obj(byte[] data) {
    try {
      RpcMessage message = (RpcMessage) objenesis.newInstance(cls);
      Schema<RpcMessage> schema = RuntimeSchema.createFrom(cls);
      ProtostuffIOUtil.mergeFrom(data, message, schema);
      return message;
    } catch (Exception e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }

}
