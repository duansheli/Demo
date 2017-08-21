
package com.fluffy.vo;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
    @NotEmpty(message="姓名不能为空")
    @Length(min=6,message="密码长度不能小于6位")
    String name;
    
    @Max(10)
    Integer age;
    
    @Past
    // 过去的时间，出生日期不能大于当前时间
    Date birth;
    
    @Size(max=10, min=3, message = "数据需在3-10之间")
    String aa1;
    
    @Email
    String e_mail;
    
    public static void main(String[] args) {
        // @NotEmpty包含了@NotNull与@Size(min = 1)
    }

    public String getName() {
    
        return name;
    }

    public void setName(String name) {
    
        this.name = name;
    }

    public Integer getAge() {
    
        return age;
    }

    public void setAge(Integer age) {
    
        this.age = age;
    }

    public Date getBirth() {
    
        return birth;
    }

    public void setBirth(Date birth) {
    
        this.birth = birth;
    }

    public String getAa1() {
    
        return aa1;
    }

    public void setAa1(String aa1) {
    
        this.aa1 = aa1;
    }

    public String getE_mail() {
    
        return e_mail;
    }

    public void setE_mail(String e_mail) {
    
        this.e_mail = e_mail;
    }
    
    
}
