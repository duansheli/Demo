package fluffy.mo.test5.core;

import java.io.Serializable;

public class RpcResponse implements Serializable {

  private String error;
  private Object resultDesc;

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public Object getResultDesc() {
    return resultDesc;
  }

  public void setResultDesc(Object resultDesc) {
    this.resultDesc = resultDesc;
  }

}
