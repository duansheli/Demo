
package com.example.entity;

import java.io.Serializable;

public class LoginUser implements Serializable {
    private static final long serialVersionUID = 1L;
    String userName;
    String pwd;
    String salt;

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getPwd() {

        return pwd;
    }

    public void setPwd(String pwd) {

        this.pwd = pwd;
    }

    public String getSalt() {

        return salt;
    }

    public void setSalt(String salt) {

        this.salt = salt;
    }

    @Override
    public String toString() {
        return String.format("LoginUser [userName=%s, pwd=%s, salt=%s]", userName, pwd, salt);
    }
    
}
