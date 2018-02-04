package com.playground.thread;


/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月4日 下午5:42:15
 * 
 * synchronized 重入
 * 
 * 暂时没想明白这个的意义、
 */

public class SyncDubbo1 {
	
	public synchronized void method1(){
		System.out.println("method1...");
		method2();
	}
	
	public synchronized void method2(){
		System.out.println("method2...");
		method3();
	}
	
	public synchronized void method3(){
		System.out.println("method3...");
	}
	
	public static void main(String[] args) {
		final SyncDubbo1  b = new SyncDubbo1();
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				b.method1();
			}
		},"t1");
		
		t1.start();
		
	}

}
