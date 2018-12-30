package fluffy.mo.test4;

import org.springframework.cglib.reflect.FastClass;
import org.springframework.cglib.reflect.FastMethod;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;

import fluffy.mo.test4.core.RpcMessage;
import fluffy.mo.test4.core.RpcRequest;
import fluffy.mo.test4.core.RpcResponse;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class Test4_ServerHandler extends ChannelInboundHandlerAdapter {
  private static Objenesis objenesis = new ObjenesisStd(true);

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    // 1. 读取消息触发
    RpcRequest req = ((RpcMessage) msg).getRequest();

    // 观察禁用此方法时控制台的输出
    // 反射调用
    Class<?> serviceClass = Class.forName(req.getServiceName() + "Impl");
    // 1.创建对象
    Object serviceBean = objenesis.newInstance(serviceClass);
    // 2. 方法名 方法参数
    String methodName = req.getMethodName();
    Class<?>[] parameterTypes = req.getTypeParameters();
    Object[] parameters = req.getParametersVal();

    // 3. 调用对象的方法
    FastClass serviceFastClass = FastClass.create(serviceClass);
    FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, parameterTypes);
    Object result = serviceFastMethod.invoke(serviceBean, parameters);
    // 远程调用成功 分装返回值
    System.out.println("远程调用  结束" + result);
    System.out.println(" 当前线程 数量 " + Thread.activeCount());
    RpcResponse respose = new RpcResponse();
    respose.setMessageId("msg_id_111");
    respose.setResultDesc(result);
    // ctx.channel().writeAndFlush(respose); // 两种方式的区别 ？
    ctx.writeAndFlush(respose);
  }

  static void print(Object... ss) {
    StringBuilder s = new StringBuilder("ch--1--");
    for (Object string : ss) {
      s.append(string);
    }
    System.out.println(s.toString());
  }
}
