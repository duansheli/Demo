package com.example.thread.disruptor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.demo.Autil;
import com.lmax.disruptor.BatchEventProcessor;
import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.util.DaemonThreadFactory;

public class RbTest1_1P1EP {
	static final int BUFFER_SIZE = 2 << 10;

	// 0. 准备工作：线程池 计数器
	static ExecutorService executor = Executors.newFixedThreadPool(3, DaemonThreadFactory.INSTANCE);

	public static void main(String[] args) throws Exception {
		// 需要生产20个
		int num = 20;
		CountDownLatch latch = new CountDownLatch(num);
		// 1. ringBuffer
		RingBuffer<FoodEvent> ringBuffer = RingBuffer.createSingleProducer(FoodEvent.EVENT_FACTORY, BUFFER_SIZE,
				new BusySpinWaitStrategy());
		// 2. ringBuffer的计数器
		SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
		// 每次生产4个苹果
		ApplePublisher publisher = new ApplePublisher(ringBuffer, num, 4, "转基因苹果");

		// 3. 消费者
		FoodPackageEventHandler handler = new FoodPackageEventHandler(latch); // 可以接收每条数据
		BatchEventProcessor<FoodEvent> batchEventProcessor = new BatchEventProcessor(ringBuffer, sequenceBarrier,
				handler);

		// 互相关联
		ringBuffer.addGatingSequences(batchEventProcessor.getSequence());

		// 启动生产者 消费者
		executor.execute(publisher);
		executor.execute(batchEventProcessor);
		
		latch.await();
		System.out.println("流程结束");

	}

	public static class ApplePublisher implements Runnable {
		private final RingBuffer<FoodEvent> ringBuffer;
		private final long iterations; // 重复次数，要发布多少个
		private final int batchSize;
		String brand;

		public ApplePublisher(RingBuffer<FoodEvent> ringBuffer, long iterations, int batchSize, String brand) {
			this.ringBuffer = ringBuffer;
			this.iterations = iterations;
			this.batchSize = batchSize;
			this.brand = brand;
		}

		@Override
		public void run() {
			try {
				// 需生成 iterations 件商品，每次生成 batchSize个商品
				for (long i = iterations; i > 0; i -= batchSize) {
					// 每次发布商品需要1秒
					Autil.w1s(0);
					// 每次申请batchSize个数据存放点
					// 例 第一次 申请16个 则占用的cas号为0-15 方法next返回值为15
					long endNum = ringBuffer.next(batchSize);
					long beginNum = endNum - (batchSize - 1);
					for (long l = beginNum; l <= endNum; l++) {
						ringBuffer.get(l).setFood(brand + l);
					}
					// 一次将 batchSize个商品发送出去
					System.out.println("生产的号码为 " + beginNum + " - " + endNum);
					ringBuffer.publish(beginNum, endNum);
				}
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	public static class FoodPackageEventHandler implements EventHandler<FoodEvent> {
		CountDownLatch latch;

		public FoodPackageEventHandler(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void onEvent(final FoodEvent event, final long sequence, final boolean endOfBatch) throws Exception {
			event.setFood(event.getFood() + " 密封包装");
			latch.countDown();
			System.out.println(event.getFood());

		}
	}

	public static class FoodEvent {
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