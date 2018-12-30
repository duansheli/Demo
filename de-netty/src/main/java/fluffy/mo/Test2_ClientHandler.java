package fluffy.mo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class Test2_ClientHandler extends SimpleChannelInboundHandler<Object> {

  private ChannelHandlerContext ctx;
  long counter = 1;

  @Override
  public void channelActive(ChannelHandlerContext ctx) {
    this.ctx = ctx;
    ctx.writeAndFlush("hello server myName is cli");
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) {
    System.out.println("cli------ channelInactive");
  }

  @Override
  public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
    System.out.println("cli------ channelRead0  " + msg);
    int i = 2;
    long l = System.currentTimeMillis();
    while ((System.currentTimeMillis() - l) < i * 1000) {

    }
    ctx.writeAndFlush("myName is cli----" + counter++);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    cause.printStackTrace();
    ctx.close();
  }

}
