package fluffy.mo.test4.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;

import fluffy.mo.test4.Test4_Server;
import fluffy.mo.test4.core.RpcClient;
import fluffy.mo.test4.core.RpcRequest;
import org.apache.commons.lang3.StringUtils;

import fluffy.mo.test4.core.RpcResponse;

public class ServiceUtil {

  @SuppressWarnings("unchecked")
  public static  <T> T create(Class<?> interfaceClass) {
      return (T) Proxy.newProxyInstance(
          interfaceClass.getClassLoader(),
          new Class<?>[]{interfaceClass},
          new InvocationHandler() {
              @Override
              public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                  RpcRequest req = new RpcRequest(); // 创建并初始化 RPC 请求
                  req.setMessageId(UUID.randomUUID().toString());
                  
                  req.setServiceName(method.getDeclaringClass().getName());
                  
                  req.setMethodName(method.getName());
                  req.setTypeParameters(method.getParameterTypes());
                  req.setParametersVal(args);


                  String host = Test4_Server.HOST;
                  int port = Test4_Server.PORT;

                  RpcClient client = new RpcClient(host, port); // 初始化 RPC 客户端
                  RpcResponse response = null; 
                  response = client.send(req);// 通过 RPC 客户端发送 RPC 请求并获取 RPC 响应
                  String error = response.getError();
                      
                  if (StringUtils.isNoneBlank(error)) {
                      throw new Exception(error);
                  } else {
                    System.out.println("远程调用 成功 结果为 "   + response.getResultDesc());
                      return response.getResultDesc();
                  }
              }
          }
      );
  }
}
