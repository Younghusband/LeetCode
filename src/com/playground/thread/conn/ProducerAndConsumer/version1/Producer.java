package com.playground.thread.conn.ProducerAndConsumer.version1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.playground.thread.conn.ProducerAndConsumer.Goods;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月27日 下午10:16:46
 * 
 * 生产者类
 * 
 */

public class Producer implements Runnable{
    
	//共享缓存区
	private BlockingQueue<Goods> queue;
	//多线程间是否启动变量，有强制从主内存中刷新的功能，即时返回线程的状态
	private volatile boolean isRunning = true;  //用来控制生命周期，每个producer线程独立
	//id生成器
	private static AtomicInteger count = new AtomicInteger();  //producer共享
	//随机对象
	private static Random r = new Random();
	
	public Producer(BlockingQueue<Goods> queue){
		this.queue = queue;
	}
	
	
	@Override
	public void run() {
		while(isRunning){
			  try {
				//模拟制造商品的时间
				Thread.sleep(r.nextInt(1000));
				//对商品编号进行累加
				int id = count.incrementAndGet();
				Goods good = new Goods(Integer.toString(id),"商品"+id+"号");
				System.out.println(Thread.currentThread().getName()+" 生产了"+good.toString()+"的商品， 正装载到公共缓冲区中。。。");
				if(!this.queue.offer(good,2,TimeUnit.SECONDS)){  //执行这个条件的判断的同时塞入了queue
					System.out.println("提交缓冲区数据失败。。。");
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void stop(){
		isRunning = false;
	}
	

}
