package fluffy.mo.test4.service;

public class HelloServiceImpl implements HelloService {

  @Override
  public String pwd(Person p) {
    if (null != p) {
      return p.getPwd()+"_已加密";
    }
    return "--1--1";
  }
}
