package com.example.demo1;
/**
 * 方式二 ：实现Runnable接口
 */
public class Test2_Runnable {
    public static void main(String[] args) {
        new Thread(new Test2_myRunnable()).start();
        System.out.println("任务1已启动  ");

        new Thread(new Test2_myRunnable()).start();
        System.out.println("任务2已启动  ");
    }

    static class Test2_myRunnable implements Runnable {
        @Override
        public void run() {
            for (int j = 0; j < 5; j++) {
                Autil.w1s(1);
                Autil.printCurrent(j);
            }
        }
    }
}
