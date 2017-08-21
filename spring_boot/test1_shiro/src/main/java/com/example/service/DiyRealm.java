package com.example.service;

import javax.annotation.PostConstruct;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.LoginUser;
import com.example.entity.UserRoles;

@Component("diyRealm")
// 参考默认的org.apache.shiro.realm.jdbc.JdbcRealm
public class DiyRealm extends AuthorizingRealm {
    @Autowired(required = true)
    UserService userService;
    
    @PostConstruct
    public void init_pwd(){
        // 设置密码加密方式为： md5
        System.out.println("设置密码加密方式为： md5");
        HashedCredentialsMatcher hashedCredentialsMatcher = new org.apache.shiro.authc.credential.HashedCredentialsMatcher("MD5");
        this.setCredentialsMatcher(hashedCredentialsMatcher);
    }

    /**
     * 授权 ： 查询用户的权限信息
     * 
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = null;
        String loginName = (String) principals.fromRealm(getName()).iterator().next();

        // 授权
        UserRoles userRoles = userService.findRoles(loginName);
        if (null != userRoles) {
            info = new SimpleAuthorizationInfo();
            info.addRoles(userRoles.getRoles());
        }
        return info;
    }

    /**
     * 认证: 即用户登陆
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token_) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) token_;
        SimpleAuthenticationInfo info=null;
        // 从数据库查询用户信息与密码
        LoginUser userInfo = userService.findUser(token.getUsername());
        String correctPwd = userInfo.getPwd();

        if (userInfo != null) {
            // 进行认证 同时保存用户信息
            info = new SimpleAuthenticationInfo(userInfo, correctPwd, getName());
        }
        String salt = userInfo.getSalt();
        if(StringUtils.isNoneBlank(salt)){
            info.setCredentialsSalt(ByteSource.Util.bytes(salt));
        }
        return info;
    }

}
