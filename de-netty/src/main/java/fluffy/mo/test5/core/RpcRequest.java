package fluffy.mo.test5.core;

import java.io.Serializable;

public class RpcRequest implements Serializable {
  private String serviceName;
  private String methodName;
  private Class<?>[] parameterTypes;
  private Object[] parameterArgs;
  
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
  public Object[] getParameterArgs() {
    return parameterArgs;
  }
  public void setParameterArgs(Object[] parameterArgs) {
    this.parameterArgs = parameterArgs;
  }
  public Class<?>[] getParameterTypes() {
    return parameterTypes;
  }
  public void setParameterTypes(Class<?>[] parameterTypes) {
    this.parameterTypes = parameterTypes;
  }
  
}
