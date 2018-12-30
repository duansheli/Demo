package fluffy.mo.test5.core;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RpcMessage implements Serializable {
  String msgId;
  RpcRequest request;
  RpcResponse rpcRespose;
  Lock lock = new ReentrantLock();
  Condition finish = lock.newCondition();

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

  public String getMsgId() {
    return msgId;
  }

  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }

  public Object call_1ForResponse() throws InterruptedException {
    try {
      lock.lock();
      // 等待2048毫秒的超时时间
      finish.await(2 << 11, TimeUnit.MILLISECONDS);
      return rpcRespose;
    } finally {
      lock.unlock();
    }
  }

  public void call_2ForSetValueAndWake(RpcResponse result) {
    try {
      // 先加锁，然后唤醒call_1的等待
      lock.lock();
      rpcRespose = result;
      finish.signal();
    } finally {
      lock.unlock();
    }
  }

}
