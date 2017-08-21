package com.fluffy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootConfigEnvApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootConfigEnvApplication.class, args);
		System.out.println("spring 启动完成------------------");
		System.out.println(context.getBean("helloBean"));
	}
}
