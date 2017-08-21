package com.fluffy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fluffy.service.EchoService;

@SpringBootApplication
public class BootDubboProviderApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BootDubboProviderApplication.class, args);
        EchoService bean = (EchoService) run.getBean("echoService");
        System.out.println("------------");
        System.out.println("result: " + bean.echo("aabb"));
    }
}
