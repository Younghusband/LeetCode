package com.playground.thread.conn.ProducerAndConsumer.version1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

import com.playground.thread.conn.ProducerAndConsumer.Goods;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月27日 下午10:33:46
 * 
 * 消费者线程
 */

public class Consumer implements Runnable{
	
	//与生产者共享的缓冲区
	private BlockingQueue<Goods> queue;
	//随机对象
	private static Random r = new Random();
	//控制消费者状态
	private volatile boolean isConsuming = true;
	
	
    public Consumer(BlockingQueue<Goods> queue){
    	this.queue = queue;
    }
	
	
	@Override
	public void run() {
		while(isConsuming){
			try {
				Goods good = this.queue.take();
				//模拟消费者获取goods的时间
				Thread.sleep(r.nextInt(1000));
				System.out.println(Thread.currentThread().getName()+" 消耗了 "+good.toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void stop(){  //感觉关闭消费者没有意义
		isConsuming = false;
	}
	
	
	

}
