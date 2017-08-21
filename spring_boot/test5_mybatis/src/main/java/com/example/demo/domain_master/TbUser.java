package com.example.demo.domain_master;

import java.io.Serializable;

/**
 * @author 
 */
public class TbUser implements Serializable {
    private Integer id;

    private String uname;

    private String pwd;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}