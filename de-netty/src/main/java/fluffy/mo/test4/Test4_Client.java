package fluffy.mo.test4;

import java.util.concurrent.TimeUnit;

import fluffy.mo.test4.service.HelloService;
import fluffy.mo.test4.service.Person;
import fluffy.mo.test4.service.ServiceUtil;
import com.google.common.base.Stopwatch;

public class Test4_Client {

  public static void main(String[] args) throws Exception {
    System.out.println("运行前线程数量 " + Thread.activeCount());
    // 1. 通过动态代理生成远程调用对象
    HelloService hs = ServiceUtil.create(HelloService.class);

    Person p = new Person();
    p.setName("zs");
    p.setPwd("123");

    Stopwatch timeCost = Stopwatch.createStarted();
    // 2. 发起调用
    String pwd = hs.pwd(p);// 远程调用
    timeCost.stop();
    System.out.println("首次请求时间 " + timeCost.elapsed(TimeUnit.MILLISECONDS));

    for (int i = 0; i < 20; i++) {
      System.out.println("请求计数  " + i);

      timeCost = Stopwatch.createStarted();
      hs.pwd(p);// 调用服务
      timeCost.stop();
      System.out.println("本次请求时间 " + timeCost.elapsed(TimeUnit.MILLISECONDS));
      if (i % 5 == 0) { // 此处可发现每次请求后的线程没有被销毁 以至于线程越来越多 此问题如何解决？
        System.out.println(i + " 当前线程 数量 " + Thread.activeCount());
      }
    }
    // 3. 输出方法返回的结果
    System.out.println("-------------------------------------" );
    System.out.println("远程调用结果为 " + pwd);
    System.out.println("返回结果后线程数量 " + Thread.activeCount());
    System.exit(0);
  }

}
