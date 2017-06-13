package com.example.demo4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.example.demo1.Autil;

public class Test_pool2 {

    /**
     * 提交一个任务， 以非阻塞方式获取结果
     */
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newCachedThreadPool();

        Future<Long> future = pool.submit(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                long acc = 0;
                for (long i = 10; i <= 20; i++) {
                    acc = acc + i;
                }
                Autil.printCurrentTimes(4);
                return acc;
            }
        });

        System.out.println("计算结果： " + future.get());
        // 禁止提交任务，不影响已经加入的任务， 如果要立即停止任务可以pool.shutdownNow()
        pool.shutdown();
    }

}
