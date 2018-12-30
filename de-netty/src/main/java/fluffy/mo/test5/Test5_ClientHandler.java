package fluffy.mo.test5;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;

import fluffy.mo.test5.core.RpcMessage;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class Test5_ClientHandler extends ChannelInboundHandlerAdapter {
  private static Objenesis objenesis = new ObjenesisStd(true);
  ConcurrentHashMap<String, RpcMessage> mapCallBack = new ConcurrentHashMap<String, RpcMessage>();
  volatile Channel channel;

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    super.channelActive(ctx);
    channel = ctx.channel();
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    // 1. 取得返回结果
    RpcMessage rm = ((RpcMessage) msg);
    String msgId = rm.getMsgId();
    RpcMessage message = mapCallBack.get(msgId);

    if (message != null) {
      mapCallBack.remove(msgId);
      message.call_2ForSetValueAndWake(rm.getRpcRespose());
    }
  }

  public RpcMessage sendRequest(RpcMessage msg) {
    mapCallBack.put(msg.getMsgId(), msg);
    channel.writeAndFlush(msg);
    return msg;
  }

}
