package com.playground.thread.conn.ProducerAndConsumer.version1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.playground.thread.conn.ProducerAndConsumer.Goods;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月27日 下午10:09:40
 * 
 * 构建一个BlockingQueue 
 * 
 * 创建若干个producer以及consumer并传入BlockingQueue
 * 
 * 用线程池启动所有的producer和consumer线程，执行三秒后关闭生产者线程，让消费者自然消耗光商品
 * 
 * 关闭线程池。
 * 
 * 如果先关闭了所有消费者，保持生产者继续生产，会产生缓冲失败的情况
 * 
 */

public class Main {
	
	public static void main(String[] args) {
		BlockingQueue queue = new LinkedBlockingQueue<Goods>(10);
		
		Producer p1 = new Producer(queue);
		Producer p2 = new Producer(queue);
		
		Consumer c1 = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		Consumer c3 = new Consumer(queue);
		Consumer c4 = new Consumer(queue);
		
		ExecutorService cachePool = Executors.newCachedThreadPool();
		//生产者
		cachePool.execute(p1);
		cachePool.execute(p2);
		//消费者
		cachePool.execute(c1);
		cachePool.execute(c2);
		cachePool.execute(c3);
		cachePool.execute(c4);
		
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		c1.stop();
//		c2.stop();
//		c3.stop();
//		c4.stop();
		
		p1.stop();
		p2.stop();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		cachePool.shutdown();  //这个并不能终止线程。。
		
	}

}
