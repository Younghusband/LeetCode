package com.playground.thread.lock;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月25日 下午8:52:43
 * 
 * 字符串常量加锁
 * 
 * sleep只会让线程进入等待，但不会释放锁。
 * 
 * 1.  如果对字符串常量加锁，锁永远不释放
 * 2.  new String() 加锁，则锁并无卵用。各线程不同步
 */

public class StringLock {
	
	public void method() {
		try {
//			synchronized ("yangfan") {
		    synchronized (new String("yangfan")) {
				while (true) {
					System.out.println(Thread.currentThread().getName() + "-----START-----");
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName() + "-----END-----");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		final StringLock opt = new StringLock();
        Thread t1 = new Thread(
        		new Runnable(){
        			public void run(){
        				opt.method();
        			}
        		},"t1");
		
        Thread t2 = new Thread(
        		new Runnable(){
        			public void run(){
        				opt.method();
        			}
        		},"t2");
        
        try {
        	t1.start();
			Thread.sleep(1);
			t2.start();  
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
