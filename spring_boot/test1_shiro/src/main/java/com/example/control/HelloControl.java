
package com.example.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.LoginUser;

/**
 * 
 * login_page : localhost:1000/index.jsp
 */
@Controller
public class HelloControl {

    @RequestMapping("/success")
    @ResponseBody
    public String sss(HttpServletRequest req, HttpServletResponse resp, Model model) {
        Subject subject = SecurityUtils.getSubject();

        Object userInfo = subject.getPrincipal();
        System.out.println("是否登陆： " + subject.isAuthenticated() );
        System.out.println("已登陆用户信息： " + userInfo);
        System.out.println("session对比： ");
        System.out.println(req.getSession());
        System.out.println(SecurityUtils.getSubject().getSession());
        return "login success";
    }

    @RequestMapping("/login")
    public String loginSubmit(String loginName, String pwd) {
        // -------------
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, pwd);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        // -------------
        return "redirect:/rest/success";
    }

    @RequestMapping("logout")
    public String loginOut(HttpServletResponse resp, HttpServletRequest req) {
        // req.getSession().invalidate();
        Subject subject = SecurityUtils.getSubject();

        System.out.println("session对比： ");
        System.out.println(req.getSession());
        System.out.println(subject.getSession());

        if (subject != null) {
            subject.logout();
        }
        // 退出，返回登录页面
        return "redirect:/rest/login";
    }

}
