package com.example.demo2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

  
/**  
* 目标： 如何终止一个运行中的线程
* 
* 1. cancel可以设置线程的属性Interrupted为false , 从而使线程停止 
*/  
public class Test5_interrupt {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();

        Future<String> sb = pool.submit(new Task());

        System.out.println("任务全部提交");
        TimeUnit.MILLISECONDS.sleep(700);
        
        sb.cancel(true);
        System.out.println("停止任务");
        pool.shutdown();

    }

    static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            
            for (int i = 0; i < 10; i++) {
                System.out.println(111+i);
                TimeUnit.MILLISECONDS.sleep(200);
            }
            return "abc" ;
        }
    }

}