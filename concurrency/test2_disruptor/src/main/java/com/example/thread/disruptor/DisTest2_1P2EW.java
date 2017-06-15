package com.example.thread.disruptor;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WorkHandler;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;

/*
 *            +-----+
 *   +------> | EW1 |
 *   |        +-----+
 * +-+--+
 * | p1 |
 * +-+--+
 *   |        +-----+
 *   +------> | EW2 |
 *            +-----+
 *            
 * P1 : produce
 * EW1 : eventWork
 * 并发执行，
 * 一个生产者，两个消费者。两个消费者会不会取到相同的数据。
 * 
 */
public class DisTest2_1P2EW {
	public static void main(String[] args) throws Exception {

		int bufferSize = 1 << 8; // 256

		Disruptor<Product> disruptor = new Disruptor<Product>(new ProductFactory(), bufferSize,
				DaemonThreadFactory.INSTANCE, ProducerType.SINGLE, new YieldingWaitStrategy());
		// 2. 两个消费者
		disruptor.handleEventsWithWorkerPool(new MyEventWorkHandler("worker-1"), new MyEventWorkHandler("worker-2"));
		RingBuffer<Product> ringBuffer = disruptor.start();

		int i = 0;
		
		while (true) {
			// 挂号预约
			long sequence = ringBuffer.next();
			try { // 获取数据对应的容器
				Product event = ringBuffer.get(sequence);

				// 存入数据
				event.set(i++);
			} finally {
				// 提交发布
				ringBuffer.publish(sequence);
			}
			if(i > 20){
			    break;
			}
		}
		System.out.println(999);
		disruptor.shutdown();
		System.out.println(888);

	}

	public static class Product {
		private long price;
		public int name;

		public Product(int n) {
			this.name = n;
		}

		public void set(long value) {
			this.price = value;
		}
	}

	public static class ProductFactory implements EventFactory<Product> {
		int count = 0;

		@Override
		public Product newInstance() {
			return new Product(count++);
		}
	}

	public static class MyEventWorkHandler implements WorkHandler<Product> {

		private String workerName;

		public MyEventWorkHandler(String workerName) {
			this.workerName = workerName;
		}

		@Override
		public void onEvent(Product event) throws Exception {
			System.out.println(workerName + " 获取接收到了对象 " + event.name);
			sleep_1s();
		}

	}

	static void sleep_1s() {
		long time = System.currentTimeMillis();
		while (System.currentTimeMillis() - time < 1000) {
		}
	}
}
