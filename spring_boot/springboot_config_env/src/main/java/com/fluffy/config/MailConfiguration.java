package com.fluffy.config;


import java.util.Properties;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "mail")
@Data
public class MailConfiguration {
    @Data
    public static class Smtp {
        private boolean auth;
        private boolean starttlsEnable;
    }

    @NotBlank
    private String host;
    private int port;
    private String from;
    private String username;
    private String password;

    @NotNull
    private Smtp smtp;
    @Autowired
    Environment env;
    
    @Autowired
    GlobalProperties gp;

    @Bean(name="abc")
    public Properties javaMailSender() {
        System.out.println("mail的初始化属性");
        System.out.println(username);
        System.out.println(password);
        System.out.println("内部类： " + smtp);
        System.out.println(env.getProperty("mail.username"));
        
        
        System.out.println("----- 属性注入 --------");
        System.out.println(gp.getEmail());
        System.out.println(gp.getThreadPool());
        
        System.out.println("----- 读取配置 --------");
        System.out.println(env.getProperty("aa.cc"));
        return new Properties();
    }
}
