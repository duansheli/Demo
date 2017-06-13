package com.example.demo1;
/**
 * 方式一 ： 继承Thread
 */
public class Test1_Thread {
  public static void main(String[] args) {
      new Test1_thread().start();
      System.out.println("任务1已启动  ");

      new Test1_thread().start();
      System.out.println("任务2已启动  ");
  }

  static class Test1_thread extends Thread {
    @Override
    public void run() {
      for (int j = 0; j < 5; j++) {
        Autil.w1s(1);
        Autil.printCurrent(j);
      }
    }
  }
}
