package com.example.thread.disruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.example.demo.Autil;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.FatalExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;

public class DisTest1_1P1EP {
	static ExecutorService pool = Executors.newCachedThreadPool();
	static int ringBufferSize = 1 << 10;// 一定数量的盘子

	/**
	 * 1 p and 1 ep
	 * 
	 * P  - Publisher
	 * EP - EventProcessor 
	 * WP - EventProcessor
	 */
	public static void main(String[] args) {
		// 初始化
		Disruptor<Food> disruptor = new Disruptor<Food>(Food.EVENT_FACTORY, ringBufferSize,
				DaemonThreadFactory.INSTANCE, ProducerType.SINGLE, new BlockingWaitStrategy());

		disruptor.setDefaultExceptionHandler(new FatalExceptionHandler());
		// 启动dsl消费者
		disruptor.handleEventsWith(new FoodEventHandler());
		disruptor.start();
		// 启动生产者
		Publisher publisher = new Publisher(disruptor.getRingBuffer(), 10);
		pool.execute(publisher);
		
		try {
            TimeUnit.SECONDS.sleep(5);
            pool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();  
        }

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

	public static class FoodEventHandler implements EventHandler<Food> {

		@Override
		public void onEvent(Food event, long sequence, boolean endOfBatch) throws Exception {
			// endOfBatch 估计当消费过快，于是队列中暂时没有数据可以消费时，则为true
			System.out.println("消费中 " + event.getName());
			Autil.w1s(0);
		}
	}

	private static class Publisher implements Runnable {
		RingBuffer<Food> ringBuffer;
		int iterations;

		public Publisher(RingBuffer<Food> ringBuffer, int iterations) {
			this.ringBuffer = ringBuffer;
			this.iterations = iterations;
		}

		@Override
		public void run() {

			for (int i = 0; i < iterations; i++) {
				// 申请空盘子
				long next = ringBuffer.next();
				// 取出对应的苹果盘，放入苹果，放入传送架
				Food Food = ringBuffer.get(next);
				Food.setName("苹果 " + i);
				ringBuffer.publish(next);
				System.out.println("生产中 " + i);
			}
		}
	}
}
