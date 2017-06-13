package com.example.demo3;

import java.util.concurrent.TimeUnit;

/**
 * join
 */
public class Test8_join {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("job ");
            }
        };

        thread.start();
        thread.join();
        System.out.println("done ");
    }
}