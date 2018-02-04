package com.playground.thread;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月3日 下午9:19:31
 * 
 * 一个对象，同步方法以及非同步方法，开两个线程分别执行
 * 
 * 没加synchronized的方法并没有收到影响
 */

public class MyObject {
	
	public synchronized void method1(){
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" is over.");
	}
	
	public void method2(){
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String [] args){
		final MyObject my = new MyObject();
		
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				my.method1();
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				my.method2();
			}
		},"t2");
		
		t1.start();
		t2.start();
		
		
	}
	

}
