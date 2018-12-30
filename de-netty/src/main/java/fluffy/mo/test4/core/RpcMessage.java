package fluffy.mo.test4.core;

import java.io.Serializable;

public class RpcMessage implements Serializable {
  RpcRequest request;
  RpcResponse rpcRespose;

  public RpcRequest getRequest() {
    return request;
  }

  public void setRequest(RpcRequest request) {
    this.request = request;
  }

  public RpcResponse getRpcRespose() {
    return rpcRespose;
  }

  public void setRpcRespose(RpcResponse rpcRespose) {
    this.rpcRespose = rpcRespose;
  }

}
