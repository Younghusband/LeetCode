package com.playground.thread.lock;

import java.util.concurrent.TimeUnit;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月27日 下午8:45:59
 * 
 * 也是死锁，只不过稍微改了一下写法
 * 
 * 
 */

public class DeadLockPro {

	public static void main(String[] args) {
		DeadLockThread t1 = new DeadLockThread(true);
		DeadLockThread t2 = new DeadLockThread(false);
		t1.setName("朱雀");
		t2.setName("玄武");
		
		t1.start();
		t2.start();
		
	}
	
	
	
}

class DeadLockThread extends Thread{
	private boolean flag;
	static Object obj1 = new Object();   //去掉static则无法形成死锁,因为每一次new Thread都会新建俩Object
	static Object obj2 = new Object();
	
	public DeadLockThread(boolean is){
		this.flag = is;
	}
	
	public void run(){
		if(flag){
			synchronized(obj1){
				System.out.println(Thread.currentThread().getName()+"entering... lock obj1");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(obj2){
					System.out.println(Thread.currentThread().getName()+"... lock obj2");
				}
			}
		}else{
			synchronized(obj2){
				System.out.println(Thread.currentThread().getName()+"entering... lock obj2");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(obj1){
					System.out.println(Thread.currentThread().getName()+"... lock obj1");
				}
			}
		}
	}
	
	
}

