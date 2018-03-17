package com.playground.thread;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月20日 下午2:26:38
 * 
 * 这里如何控制t1.t2谁先拿到锁呢？
 */

public class ObjectLock {
	
    int count = 0;
	
	public void oper(){
			System.out.println(Thread.currentThread().getName()+" 进入到该方法。");
			try {
				synchronized(this){  
				Thread.sleep(4000);
				count++;
				System.out.println("count加1");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" 结束。");
	}
	
	public void getCount(){
		System.out.println(Thread.currentThread().getName()+" 进入到该方法。");
		synchronized(this){  
		    System.out.println(Thread.currentThread().getName()+" 获得值"+ count);
		}
	}
	
	
	
	public static void main(String[] args) {
		ObjectLock lock = new ObjectLock();
		Thread t1 = new Thread(
				new Runnable(){
					public void run(){
						lock.oper();
					}
				}
				,"t1");
		
		Thread t2 = new Thread(
				new Runnable(){
					public void run(){
						lock.getCount();
					}
				}
				,"t2");
		
		t1.start();
		t2.start();
		
	}
	

}
