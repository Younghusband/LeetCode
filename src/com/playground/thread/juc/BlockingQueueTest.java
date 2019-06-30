package com.playground.thread.juc;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description
 * @author vermouth.Mac
 * @version 2018年3月18日 下午8:48:55
 * 
 * 阻塞队列提供了可阻塞的入队和出对操作，如果队列满了，入队操作将阻塞直到有空间可用，如果队列空了，出队操作将阻塞直到有元素可用；
 * 队列可以为有界和无界队列，无界队列不会满，因此入队操作将不会阻塞；
 * 
 * 简单测试blockingQueue
 * 
 * 思考: 生产者，消费者的对象 
 * 
 */

public class BlockingQueueTest {
	
	public static void main(String[] args) {
		//这个地方可以替换Queue种类
		BlockingQueue<String> queue =  new LinkedBlockingQueue<String>();
		ExecutorService pool = Executors.newCachedThreadPool();
		PutPeople p1 = new PutPeople(queue);
		PutPeople p2 = new PutPeople(queue);
		
		pool.execute(p1);
		pool.execute(p1);
		
		
		
		TakePeople t = new TakePeople(queue);
		pool.execute(t);
		pool.execute(t);
		pool.execute(t);
		pool.execute(t);
		
		
		
	}

}

class PutPeople implements Runnable {
	BlockingQueue<String> queue;
	Random r;
	AtomicInteger count = new AtomicInteger(20);
	public PutPeople(BlockingQueue<String> queue){
		this.queue = queue;
		r = new Random();
	}

	@Override
	public void run() {
		while (count.get() > 0) {  //每个生产者只让他生产100个产品
			try {
				Thread.sleep(r.nextInt(1000));
				int id = count.decrementAndGet();
				SemaphoreTest.print("生产了 "+"A-" + id);
				if (!queue.offer("A-" + id, 2, TimeUnit.SECONDS)) {
					SemaphoreTest.print(" 放入缓冲区失败！！！");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class TakePeople implements Runnable {
	BlockingQueue<String> queue;
	Random r;
	public TakePeople(BlockingQueue<String> queue){
		this.queue = queue;
		r = new Random();
	}

	@Override
	public void run() {
		while(true){
			try {
				String data = queue.take();
				Thread.sleep(1000+r.nextInt(1000));
				SemaphoreTest.print(" 消费了 "+data);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
