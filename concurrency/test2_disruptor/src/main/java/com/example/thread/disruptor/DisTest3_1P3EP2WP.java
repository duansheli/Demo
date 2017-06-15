package com.example.thread.disruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.demo.Autil;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.FatalExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WorkHandler;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;

/**
 * 
 *  +----+              +-----+
 *  | P1 |              | EW1 | 两个work处理的数据不会相同
 *  +-+--+              | EW2 |
 *    |                 +-----+
 *    |
 *    v                    ^
 *                         |
 * +---------+             |
 * | handle1 |        +----+----+
 * | handle2 +---->   | handle3 |
 * +---------+        +---------+
 * handle(1 2)会处理相同的数据，
 * 但不分先后顺序
 *
 *
 */
public class DisTest3_1P3EP2WP {
	static ExecutorService pool = Executors.newCachedThreadPool();
	static int ringBufferSize = 1 << 10;

	/**
	 * 使用Disruptor进行数据处理，可以便捷的描述先后顺序 依赖关系 
	 * 1个生产者 -----> 3个顺序订阅 -----> 2个消费
	 */
	public static void main(String[] args) {
		Disruptor<Food> disruptor = new Disruptor<Food>(Food.EVENT_FACTORY, ringBufferSize,
				DaemonThreadFactory.INSTANCE, ProducerType.SINGLE, new BlockingWaitStrategy());
		RingBuffer<Food> ringBuffer = disruptor.getRingBuffer();
		disruptor.setDefaultExceptionHandler(new FatalExceptionHandler());

		// 类似订阅 handler1处理之后handle2处理
		FoodEventHandler handler1 = new FoodEventHandler("洒水");
		FoodEventHandler handler2 = new FoodEventHandler("去叶");
		FoodPackageEventHandler handler3 = new FoodPackageEventHandler();
		// handler1 handler2 二者的顺序可以不一样，但不会同时处理一条数据
		disruptor.handleEventsWith(handler1, handler2)
				//handler3一定会在这二者之后执行
				.then(handler3)
				// 消息队列 两个工人不会消费同样的数据
				.thenHandleEventsWithWorkerPool(new MyEventWorkHandler("质检A"), new MyEventWorkHandler("质检B"));
		// 将生产者放入线程池
		Publisher publisher1 = new Publisher(ringBuffer, 10);
		pool.execute(publisher1);
		// 启动dsl消费者
		disruptor.start();
		sleep_1s(5);
	}

	public static class Food {
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public static final EventFactory<Food> EVENT_FACTORY = new EventFactory<Food>() {
			public Food newInstance() {
				return new Food();
			}
		};
	}

	public static class FoodPackageEventHandler implements EventHandler<Food> {

		@Override
		public void onEvent(Food event, long sequence, boolean endOfBatch) throws Exception {
			System.out.println("当前处理器#泡沫 需处理的对象为：  " + event.getName());
			event.setName(event.getName() + " 防摔泡沫 ");
		}
	}

	public static class FoodEventHandler implements EventHandler<Food> {
		String name;

		public FoodEventHandler(String name) {
			this.name = name;
		}

		@Override
		public void onEvent(Food event, long sequence, boolean endOfBatch) throws Exception {
			System.out.println("当前处理器#" + name + " 需处理的对象为：  " + event.getName());
			event.setName(event.getName() + name);
			Autil.w1s(0);
		}
	}

	static class Publisher implements Runnable {
		RingBuffer<Food> ringBuffer;
		int iterations;

		public Publisher(RingBuffer<Food> ringBuffer, int iterations) {
			this.ringBuffer = ringBuffer;
			this.iterations = iterations;
		}

		@Override
		public void run() {

			for (int i = 0; i < iterations; i++) {
				long next = ringBuffer.next();
				Food Food = ringBuffer.get(next);
				Food.setName("苹果 " + i);
				ringBuffer.publish(next);
				System.out.println("生产中 " + i);
			}
		}
	}

	public static class MyEventWorkHandler implements WorkHandler<Food> {

		private String workerName;

		public MyEventWorkHandler(String workerName) {
			this.workerName = workerName;
		}

		@Override
		public void onEvent(Food event) throws Exception {
			System.out.println("当前处理器#" + workerName + " 需处理的对象为：" + event.getName());
			event.setName(event.getName() + " 质检员：" + workerName);
			sleep_1s(0);
		}

	}

	static void sleep_1s(int i) {
		i = i < 1 ? 1 : i;
		long time = System.currentTimeMillis();
		while (System.currentTimeMillis() - time < i * 1000) {
		}
	}
}
