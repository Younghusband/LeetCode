package com.playground.thread.lock;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月25日 上午11:55:29
 * 
 * 测试lock
 */

public class TestLock {
	
	int count;
	String lock = "lock";
	
	public void add(){
		System.out.println(Thread.currentThread().getName()+"------");
		synchronized(lock){
		    System.out.println(Thread.currentThread().getName()+"进入锁");
			lock.notify();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"锁之外");
		
		
	}
	
	public void de() {
		System.out.println(Thread.currentThread().getName()+"------");
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName()+"进入锁");
			try {
				System.out.println("t2等待");
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("随便玩");

	}
	
	
	
	
	
	public static void main(String[] args) {
		final TestLock test = new TestLock();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				test.add();
			}
		}, "t1"

		);
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				test.de();
			}
		}, "t2"
				
				);
		
		t2.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();
		
		
		
		
	}

}
