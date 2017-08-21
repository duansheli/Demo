package com.fluffy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Client {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Client.class, args);
        AbcService bean = run.getBean(AbcService.class);
        System.out.println("------------------------");
        System.out.println(bean.echoService.echo("abccc"));
    }
}