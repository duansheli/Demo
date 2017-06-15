package com.example.netty.test4.core;

import java.io.Serializable;

public class RpcRequest implements Serializable {
  private String messageId;
  private String serviceName;
  private String methodName;
  private Class<?>[] typeParameters;
  private Object[] parametersVal;
  public String getMessageId() {
    return messageId;
  }
  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }
  public String getServiceName() {
    return serviceName;
  }
  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }
  public String getMethodName() {
    return methodName;
  }
  public void setMethodName(String methodName) {
    this.methodName = methodName;
  }
  public Class<?>[] getTypeParameters() {
    return typeParameters;
  }
  public void setTypeParameters(Class<?>[] typeParameters) {
    this.typeParameters = typeParameters;
  }
  public Object[] getParametersVal() {
    return parametersVal;
  }
  public void setParametersVal(Object[] parametersVal) {
    this.parametersVal = parametersVal;
  }
  
}
