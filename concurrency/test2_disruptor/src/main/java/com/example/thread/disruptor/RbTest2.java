package com.example.thread.disruptor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.example.demo.Autil;
import com.lmax.disruptor.BatchEventProcessor;
import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.util.DaemonThreadFactory;


public class RbTest2 {
	private static final int NUM_PUBLISHERS = 3;
	private static final int BUFFER_SIZE = 1024 * 64;
	private static final long ITERATIONS = 1000L * 1000L * 20L;

	// 0. 准备工作：线程池 计数器
	ExecutorService executor = Executors.newFixedThreadPool(NUM_PUBLISHERS + 1, DaemonThreadFactory.INSTANCE);
	CyclicBarrier cyclicBarrier = new CyclicBarrier(NUM_PUBLISHERS + 1);

	public long runDisruptorPass() throws Exception {
		// disruptor begin
		// 1. ringBuffer
		RingBuffer<FoodEvent> ringBuffer = RingBuffer.createMultiProducer(FoodEvent.EVENT_FACTORY, BUFFER_SIZE,
				new BusySpinWaitStrategy());
		// 2. ringBuffer的计数器
		SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
		// 生产者数组
		ApplePublisher[] valuePublishers = new ApplePublisher[NUM_PUBLISHERS];
		// 3. 一个消费者
		FoodPackageEventHandler handler = new FoodPackageEventHandler(); // 可以接收每条数据
		BatchEventProcessor<FoodEvent> batchEventProcessor = new BatchEventProcessor(ringBuffer, sequenceBarrier,
				handler);

		// 创建多个生产者
		for (int i = 0; i < NUM_PUBLISHERS; i++) {
			valuePublishers[i] = new ApplePublisher(cyclicBarrier, ringBuffer, ITERATIONS / NUM_PUBLISHERS, 16,
					"p_" + i);
		}
		ringBuffer.addGatingSequences(batchEventProcessor.getSequence());

		final CountDownLatch latch = new CountDownLatch(1);
		System.out.println(ITERATIONS + " // " + NUM_PUBLISHERS + " = " + ITERATIONS / NUM_PUBLISHERS);
		handler.reset(latch,
				batchEventProcessor.getSequence().get() + ((ITERATIONS / NUM_PUBLISHERS) * NUM_PUBLISHERS));
		Future<?>[] futures = new Future[NUM_PUBLISHERS];
		// 启动生产者
		for (int i = 0; i < NUM_PUBLISHERS; i++) {
			futures[i] = executor.submit(valuePublishers[i]);
		}
		// 一个消费者
		executor.submit(batchEventProcessor);
		long start = System.currentTimeMillis();

		// 所有的生产者同时工作
		cyclicBarrier.await(); // start test
		for (int i = 0; i < NUM_PUBLISHERS; i++) {
			futures[i].get();
			// 当循环结束 则意味着所有的子线程都有了返回结果，也就是运行结束了
		}

		// 获取当前运行的线程数量
		System.out.println(Thread.activeCount());

		latch.await(); // 当消费者处理完成后，此处会被唤醒，计算任务耗时
		long opsPerSecond = (ITERATIONS * 1000L) / (System.currentTimeMillis() - start);
		batchEventProcessor.halt();
		return opsPerSecond;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(Runtime.getRuntime().availableProcessors()); // 输出当前系统是几核的cpu
		RbTest2 m = new RbTest2();
		System.out.println("opsPerSecond:" + m.runDisruptorPass());
	}

	public static class ApplePublisher implements Runnable {
		private final CyclicBarrier cyclicBarrier;
		private final RingBuffer<FoodEvent> ringBuffer;
		private final long iterations; // 重复次数，要发布多少个
		private final int batchSize;
		String brand;

		public ApplePublisher(CyclicBarrier cyclicBarrier, RingBuffer<FoodEvent> ringBuffer, long iterations,
				int batchSize, String brand) {
			this.cyclicBarrier = cyclicBarrier;
			this.ringBuffer = ringBuffer;
			this.iterations = iterations;
			this.batchSize = batchSize;
			this.brand = brand;
		}

		@Override
		public void run() {
			try {
				cyclicBarrier.await();
				System.out.println(Thread.currentThread().getName());
				if (!(Thread.currentThread().getName().indexOf("1") > 0)) {
					Autil.w1s(2);// 线程1每次要消耗2秒
				}
				// 需生成 iterations 件商品，每次生成 batchSize个商品
				for (long i = iterations; i > 0; i -= batchSize) {
					// 每次申请batchSize个数据存放点
					// 例 第一次 申请16个 则占用的cas号为0-15 方法next返回值为15
					long endNum = ringBuffer.next(batchSize);
					long beginNum = endNum - (batchSize - 1);
					for (long l = beginNum; l <= endNum; l++) {
						ringBuffer.get(l).setFood(brand + l);
					}
					// 一次将 batchSize个商品发送出去
					ringBuffer.publish(beginNum, endNum);
				}
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	public final class FoodPackageEventHandler implements EventHandler<FoodEvent> {
		String food = null;
		private long count;
		private CountDownLatch latch;

		public void reset(final CountDownLatch latch, final long expectedCount) {
			this.latch = latch;
			count = expectedCount;
		}

		@Override
		public void onEvent(final FoodEvent event, final long sequence, final boolean endOfBatch) throws Exception {
			event.getFood();
			if (count == sequence) {
				latch.countDown();
			}
		}
	}

	public static final class FoodEvent {
		private String food;

		public String getFood() {
			return food;
		}

		public void setFood(String food) {
			this.food = food;
		}

		public static final EventFactory<FoodEvent> EVENT_FACTORY = new EventFactory<FoodEvent>() {
			public FoodEvent newInstance() {
				return new FoodEvent();
			}
		};
	}
}