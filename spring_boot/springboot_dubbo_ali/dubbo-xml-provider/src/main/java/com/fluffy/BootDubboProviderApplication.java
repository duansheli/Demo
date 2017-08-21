package com.fluffy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BootDubboProviderApplication {

    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext("dubbo-demo-provider.xml").start();

        // 提交一个空线程任务，使main不会退出
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(() -> {
        });
        System.out.println("start success");

    }
}
