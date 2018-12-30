package com.example.netty.test5.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.example.netty.test5.Test5_Client;
import com.example.netty.test5.Test5_Client.Sender;
import com.example.netty.test5.Test5_ClientHandler;
import com.example.netty.test5.Test5_Server;
import com.example.netty.test5.core.RpcMessage;
import com.example.netty.test5.core.RpcRequest;
import com.example.netty.test5.core.RpcResponse;
import com.google.common.reflect.AbstractInvocationHandler;

public class ServiceUtil {

  @SuppressWarnings("unchecked")
  public static <T> T create(Class<?> interfaceClass) {
    return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[] { interfaceClass },
        new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            RpcMessage msg = buildRequestMsg(proxy, method, args);// 创建并初始化 RPC
                                                                  // 请求

            String host = Test5_Server.HOST;
            int port = Test5_Server.PORT;

            // 通过 RPC 客户端发送 RPC 请求并获取 RPC 响应
            Sender.getInstance().getMessageSendHandler().sendRequest(msg);
            // 获取结果
            RpcResponse response = (RpcResponse) msg.call_1ForResponse();

            String error = response.getError();

            if (StringUtils.isNoneBlank(error)) {
              throw new Exception(error);
            } else {
              System.out.println("远程调用 成功 结果为 " + response.getResultDesc());
              return response.getResultDesc();
            }
          }
        });
  }

  static RpcMessage buildRequestMsg(Object proxy, Method method, Object[] args) {
    RpcMessage msg = new RpcMessage();
    msg.setMsgId(UUID.randomUUID().toString());
    // 设置远程调用的参数
    RpcRequest req = new RpcRequest(); // 创建并初始化 RPC 请求
    req.setServiceName(method.getDeclaringClass().getName());
    req.setMethodName(method.getName());
    req.setParameterTypes(method.getParameterTypes());
    req.setParameterArgs(args);
    msg.setRequest(req);
    return msg;
  }

  public static class MessageSendProxy extends AbstractInvocationHandler {

    @Override
    protected Object handleInvocation(Object proxy, Method method, Object[] args) throws Throwable {
      // 1. 创建请求对象
      RpcMessage msg = buildRequestMsg(proxy, method, args);
      // 2. 获取发送客户端
      // 3. 发送消息到服务端
      Test5_ClientHandler handler = Test5_Client.Sender.getInstance().getMessageSendHandler();
      RpcMessage callBack = handler.sendRequest(msg);
      return callBack.call_1ForResponse();
    }

  }

}
