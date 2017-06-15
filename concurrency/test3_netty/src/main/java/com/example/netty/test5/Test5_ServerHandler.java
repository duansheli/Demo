package com.example.netty.test5;

import org.springframework.cglib.reflect.FastClass;
import org.springframework.cglib.reflect.FastMethod;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;

import com.example.netty.test5.core.RpcMessage;
import com.example.netty.test5.core.RpcRequest;
import com.example.netty.test5.core.RpcResponse;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class Test5_ServerHandler extends ChannelInboundHandlerAdapter {
  private static Objenesis objenesis = new ObjenesisStd(true);

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    // 1. 读取消息触发
    RpcMessage rpcMsg = ((RpcMessage) msg);
    RpcRequest req = rpcMsg.getRequest();

    // 观察禁用此方法时控制台的输出
    // 反射调用
    Class<?> serviceClass = Class.forName(req.getServiceName() + "Impl");
    // 1.创建对象
    Object serviceBean = objenesis.newInstance(serviceClass);
    // 2. 方法名 方法参数
    String methodName = req.getMethodName();
    Class<?>[] parameterTypes = req.getParameterTypes();
    Object[] parameters = req.getParameterArgs();

    // 3. 调用对象的方法
    FastClass serviceFastClass = FastClass.create(serviceClass);
    FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, parameterTypes);
    Object result = serviceFastMethod.invoke(serviceBean, parameters);
    
    // 远程调用成功 分装返回值
//    String result = "123";
    System.out.println("远程调用  结束" + result);
    System.out.println(" 当前线程 数量 " + Thread.activeCount());
    RpcResponse respose = new RpcResponse();
    respose.setResultDesc(result);
    rpcMsg.setRequest(null);
    rpcMsg.setRpcRespose(respose);
    // ctx.channel().writeAndFlush(respose); // 两种方式的区别 ？
    ctx.writeAndFlush(rpcMsg);
  }

  static void print(Object... ss) {
    StringBuilder s = new StringBuilder("ch--1--");
    for (Object string : ss) {
      s.append(string);
    }
    System.out.println(s.toString());
  }
}
