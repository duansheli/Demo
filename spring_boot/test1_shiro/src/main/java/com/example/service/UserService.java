
package com.example.service;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import com.example.entity.LoginUser;
import com.example.entity.UserRoles;

@Service
public class UserService {
    public LoginUser findUser(String userName) {
        System.out.println("登陆前。。。 查询登陆用户");
        LoginUser user = null;

        if ("admin".equals(userName) ) {
            user = new LoginUser();
            user.setUserName(userName);
            // 数据库保存的是加盐加密后的密码
            String pwd = "123";
            String salt = "salt_abc";
            SimpleHash hash = new SimpleHash("MD5", pwd, salt);
            System.out.println("加盐后的密码" + pwd);
            user.setPwd(hash.toHex());
            user.setSalt(salt);
        }

        return user;
    }

    public UserRoles findRoles(String userName) {
        UserRoles roles = null;
        if ("admin".equals(userName)) {
            roles = new UserRoles(Arrays.asList("superUser"));
        }

        return roles;
    }

}
