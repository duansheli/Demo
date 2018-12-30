package fluffy.mo.test5.service;

public class Person {
  String name;
  String pwd;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  @Override
  public String toString() {
    return "Test3_person [name=" + name + ", pwd=" + pwd + "]";
  }

}
