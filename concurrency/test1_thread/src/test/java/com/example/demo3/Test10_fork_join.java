package com.example.demo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * join
 */
public class Test10_fork_join {

    final static ForkJoinPool forkJoinPool = new ForkJoinPool();
    public static void main(String[] args) throws InterruptedException {
        List<String> blueApples = Arrays.asList("b1", "b2", "b3");
        List<String> redApples = Arrays.asList("r1", "r2", "r3", "r4");
        
        ShopTask shopTask = new ShopTask(blueApples, redApples);
        
        Long allMoney = forkJoinPool.invoke(shopTask);
        System.out.println("总销售额 ： "+allMoney);
    }


    static class ShopTask extends RecursiveTask<Long> {
        List<String> blueApples;
        List<String> redApples;

        public ShopTask(List<String> blueApples, List<String> redApples) {
            this.blueApples = blueApples;
            this.redApples = redApples;
        }

        @Override
        protected Long compute() {
            List<RecursiveTask<Long>> taskList = new ArrayList<>();
            long all = 0;
            BlueAppleTask blueAppleTask = new BlueAppleTask(blueApples);
            RedAppleTask redAppleTask = new RedAppleTask(redApples);

            blueAppleTask.fork();
            taskList.add(blueAppleTask);

            redAppleTask.fork();
            taskList.add(redAppleTask);

            for (RecursiveTask<Long> recursiveTask : taskList) {
                all += recursiveTask.join();
            }

            return all;
        }

    }

    static class BlueAppleTask extends RecursiveTask<Long> {
        List<String> blueApples;

        public BlueAppleTask(List<String> blueApples) {
            this.blueApples = blueApples;
        }

        @Override
        protected Long compute() {
            long sumMoney = 0;
            sumMoney = blueApples.size() * 10;
            return sumMoney;
        }

    }

    static class RedAppleTask extends RecursiveTask<Long> {
        List<String> redApples;

        public RedAppleTask(List<String> redApples) {
            this.redApples = redApples;
        }

        @Override
        protected Long compute() {
            long sumMoney = 0;
            sumMoney = redApples.size() * 20;
            return sumMoney;
        }

    }

}