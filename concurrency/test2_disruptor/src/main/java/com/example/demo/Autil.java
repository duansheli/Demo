package com.example.demo;

import java.util.concurrent.TimeUnit;

public class Autil {
    /**
     * 等待几秒
     * 
     * @param i
     *            运行秒数
     */
    public static void w1s(int i) {
        // 如果小于0, 则设为1秒
        i = (i < 1) ? 1 : i;
        long difference = TimeUnit.SECONDS.toNanos(i);
        long begin = System.nanoTime();
        while ((System.nanoTime() - begin) < difference) {

        }
    }

    public static void printCurrent(int i) {
        // 打印线程名
        System.out.println("## 线程" + Thread.currentThread().getName() + "正在执行  " + i);
    }

    public static void printCurrentTimes(int i) {
        try {
            for (; i > 0; i--) {
                TimeUnit.MILLISECONDS.sleep(200);
                // 打印线程名
                System.out.println("## 线程" + Thread.currentThread().getName() + "正在执行  " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
