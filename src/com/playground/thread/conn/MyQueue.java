package com.playground.thread.conn;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月24日 下午10:27:26
 * 
 * 实现最简单的阻塞队列。
 * 
 * 设定尺寸，put元素的时候如果队列为满的阻塞等待take唤醒
 *         take元素的时候如果队列为空阻塞等待put唤醒。
 * 
 */

public class MyQueue {
	
	private int maxSize;      //队列尺寸
	private int minSize = 0;  //队列最少元素
	private AtomicInteger count = new AtomicInteger(0);
//	private int count = 0;
	private LinkedList<String> queue = new LinkedList<String>();   //注意，队列的方法是linkedList的，如果写List ... = new LinkedList 使用时需要转换
	public String lock = "lock";
	
	public MyQueue(int maxSize){
		this.maxSize = maxSize;
	}
	
	public void put(String n) throws InterruptedException{
		synchronized(lock){
		if(count.get()==this.maxSize){
			System.out.println("队列满了，等待取出");
			lock.wait();
		}
		queue.add(n);
		count.incrementAndGet();
		lock.notify();
		System.out.println(Thread.currentThread().getName()+"新加入了元素"+n);
		}
	}
	
	public String take() throws InterruptedException {
		String result = null;
		synchronized (lock) {
			if (count.get()==this.minSize) {  //不能用equals来比较
				System.out.println("队列为空，等待放入");
				lock.wait();
			}
			result=queue.removeFirst();  // removeFirst
			count.decrementAndGet();
            lock.notify();
            System.out.println(Thread.currentThread().getName()+"取出了元素"+result);
		}
		return result;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		final MyQueue queue = new MyQueue(4);
		
		// 如果用循环put的话，永远走不到下面   还是那句话不要在循环里使用notify
//		for(int i=0;i<10;i++){
//			queue.put(i+"");
//		}
		queue.put("1");
		queue.put("2");
		queue.put("c");
		queue.put("d");
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					queue.put("y");
					Thread.sleep(500);
					queue.put("f");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "producer");
		
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					queue.take();
					Thread.sleep(500);
					queue.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "consumer");
		
		t2.start();
		t1.start();
		
		
		
	}
	
	
}
