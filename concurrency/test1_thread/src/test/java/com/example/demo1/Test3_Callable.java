package com.example.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 方式三 ： 有返回值的线程， 实现Callable。 两种获取返回结果的方式
 */
public class Test3_Callable {

    /**
     * 需要将任务交给线程池
     */
    public static void main(String[] args) throws Exception {
        // 1. 创建线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        // 2. 向线程池提交任务
        Future<Integer> future1 = pool.submit(new Test3_myCallable());
        System.out.println("任务1已提交  ");

        // 3. 获取线程的返回值
        System.out.println("------------------开始查询所有子线程的返回值   ");
        // --3.1 获取方式一： 阻塞方式等待返回值
        // Integer j = future1.get();

        int flag = 10;

        // --3.2 获取方式二，不停的询问线程任务是否执行完成了
        while (10 == flag) {
            if (future1.isDone()) {
                flag = 6;
                System.out.println(" ");
                System.out.println(flag + "返回值为  " + future1.get());
            } else {
                System.out.print("任务尚未完成 ");
                Thread.sleep(50);
            }
        }

        // 线程池运行结束后关闭
        pool.shutdown();
        System.out.println("运行结束  " + Thread.activeCount());
    }

    static class Test3_myCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Autil.w1s(1);
            Autil.printCurrentTimes(3);
            return 33;
        }
    }

}
