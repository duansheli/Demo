package com.example.demo2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.example.demo1.Autil;

/**
 * 通过设置标志位实现线程的停止
 */
public class Test7_stopFlag {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        // 1. 创建 提交任务
        Task task = new Task();
        Future<String> sb = pool.submit(task);

        System.out.println("任务提交");

        try {// 获取结果时， 设置超时时间
            String result = sb.get(3, TimeUnit.SECONDS);
            System.out.println("任务结果 ： " + result);
        } catch (ExecutionException | TimeoutException e) {
            e.printStackTrace();
            System.out.println("任务超时 ， 停止任务");
            task.keepRun = false;
        }

        System.out.println("done ");
        pool.shutdown();

    }

    static class Task implements Callable<String> {
        volatile boolean keepRun = true;

        @Override
        public String call() throws Exception {
            int i = 0;
            while (keepRun) {
                System.out.println(1 + i++);
                Autil.w1s(1);
                if(i>100){
                    return "download:" + i;
                }
            }
            return "download:skip";
        }

    }

}