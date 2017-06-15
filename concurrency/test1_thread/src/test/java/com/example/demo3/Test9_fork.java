
package com.example.demo3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 当工作量大时，对任务进行水平拆分。
 */
public class Test9_fork {
    public static void main(String[] args) throws Exception {
        ForkJoinPool fjp = new ForkJoinPool();

        Sum sum = new Sum(1, 1_0);
        ForkJoinTask<Long> task = fjp.submit(sum);
        System.out.println("提交完毕");

        Long result = task.get();
        System.out.println("输出结果" + result);

    }

    static class Sum extends RecursiveTask<Long> {
        private final long from;
        private final long to;

        Sum(long from, long to) {
            this.from = from;
            this.to = to;
        }

        static boolean tooBiger(long from, long to) {
            return (to - from) > 3 ? true : false;
        }

        static long sum(long from, long to) {
            long sum = 0;
            for (; from < to; from++) {
                sum += from;
            }
            return sum;
        }

        @Override
        protected Long compute() {
            if (tooBiger(from, to)) {
                // 任务量太大
                long middle = (to + from) / 2;
                Sum sum1 = new Sum(from, middle);
                Sum sum2 = new Sum(middle, to);

                sum1.fork();
                sum2.fork();
                long sum = 0;
                sum = sum1.join() + sum2.join();

                System.out.println(sum + "  " + from + " > " + middle + " > " + to);
                return sum;
            } else {
                long sum = sum(from, to);
                System.out.println(sum + " == " + from + " > " + to);
                return sum;
            }

        }

    }
}
