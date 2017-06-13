package com.example.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 已经提交的任务可以被中断
 */
public class Test4_Callable2 {

    public static void main(String[] args) throws Exception {
        // 1. 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Test4_myCallable tc = new Test4_myCallable();
        // 2. 提交任务
        Future<Integer> future = executor.submit(tc);
        System.out.println("任务已提交");
        
        // 3. 获取返回结果
        try {//设置超时时间
            Integer result = future.get(2, TimeUnit.SECONDS);
            System.out.println("该线程的返回值  " + result);
        } catch (Exception e) {
            System.out.println("中断任务");
            future.cancel(true);
        }
        System.out.println("main结束  ");
        executor.shutdown();
    }

    static class Test4_myCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int j = 9;
            for (; j > 0; j--) {
                TimeUnit.MILLISECONDS.sleep(300);
                Autil.printCurrent(j);
            }
            System.out.println("-----------任务执行完成");
            return j;
        }
    }

}
