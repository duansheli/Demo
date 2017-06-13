package com.example.demo2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**  
* 如何终止一个运行中的线程
* 2. 通过对异常InterruptedException的catch ， 线程并不能被终止。 
* 退出已经启动的线程原理： 检查线程变量  Interrupted ， 当为false则抛出异常终止线程。
*/ 
public class Test6_interrupt2 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();

        Future<String> sb = pool.submit(new Task());

        System.out.println("任务全部提交");
        TimeUnit.MILLISECONDS.sleep(700);

        sb.cancel(true);
        System.out.println("停止任务");
        pool.shutdown();

    }

    /**
     * 该代码表明，并非java终止线程的方式其实是通过检查 isInterrupted 状态实现的
     */
    static class Task implements Callable<String> {

        // isInterrupted翻译为中断状态， 是java提供的是否需要停止线程的标记
        // 相当于【 if(flag == 关闭){throw new InterruptedException();} 】 即关闭线程
        // Thread.currentThread().isInterrupted()默认是false
        /*---------------------------------------------------------------------*/
        @Override
        public String call() throws Exception {

            for (int i = 0; i < 10; i++) {
                System.out.println(111 + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("线程已收到中断请求");
                    // throw new InterruptedException();
                }

            }
            return "abc";
        }

    }

}