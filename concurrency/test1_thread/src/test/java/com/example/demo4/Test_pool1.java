package com.example.demo4;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.example.demo1.Autil;

public class Test_pool1 {
    
    /**
     * 提交一组任务
     */
    public static void main(String[] args) throws Exception {
        // 1. 创建线程池
        ExecutorService pool = Executors.newCachedThreadPool();

        // 2. 向线程池提交3个任务
        // 提交多个任务, invokeAll表示等待所有的线程都运行结束
        List<Future<Long>> list = pool
                .invokeAll(Arrays.asList(new Sum(0, 10), new Sum(100, 1_000), new Sum(10_000, 1_000_000)));

        // 3. 获取线程的返回值
        System.out.println("------------------开始遍历所有子线程的返回值   ");

        for (Future<Long> f : list) {
            System.out.println("返回值为  " + f.get());
        }

        pool.shutdown();
    }

    static class Sum implements Callable<Long> {
        private final long from;
        private final long to;

        Sum(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() {
            long acc = 0;
            for (long i = from; i <= to; i++) {
                acc = acc + i;
            }
            Autil.printCurrentTimes(4);
            return acc;
        }
    }

}
