package com.playground.thread;

import java.util.concurrent.TimeUnit;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月28日 下午1:03:03
 * 
 * 测试synchronized的可重入性
 * 
 * 由于synchronized是可重入的，所以在method1的锁被释放之前就可以进入到method2
 * 
 */

public class ReentrantTest1 {
	
	
	public synchronized void method1(){
		method2();  //测试synchronized的可重入性
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-------method1");
	}
	
	public synchronized void method2(){
		System.out.println(Thread.currentThread().getName()+"-------method2");
	}
	
	public void method3(){
		System.out.println(Thread.currentThread().getName()+"-------method3");
	}
	
	public static void main(String[] args) {
		ReentrantTest1 test = new ReentrantTest1();
		ReentrantTest1 test2 = new ReentrantTest1();
		
		
		Thread t1 = new Thread(
				new Runnable(){
					public void run(){
						test.method1();
					}
				}
				);
		
		Thread t2 = new Thread(
				new Runnable(){
					public void run(){
						test.method3();
						test2.method2();
					}
				}
				);
		
		
		t1.start();
//		t2.start();
		
	}

}
