package com.fluffy;

import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

public class User2 {
  @Excel(name = "用户名")
  String name;
  @Excel(name = "密码", type = 2)
  String pwd;
  @Excel(name = "年龄")
  String age;
  @Excel(name = "生日", format = "yyyy+MM+dd")
  Date birth;

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public Date getBirth() {
    return birth;
  }

  public String getName() {
    return name;
  }

  public String getPwd() {
    return pwd;
  }

  public String getAge() {
    return age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public void setAge(String age) {
    this.age = age;
  }

}