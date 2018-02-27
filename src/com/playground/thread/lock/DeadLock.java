package com.playground.thread.lock;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月5日 下午10:17:24
 * 
 * 
 */

public class DeadLock {
	
	public static void main(String[] args) {
		Object lock1 = new Object();
		Object lock2 = new Object();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				synchronized (lock1) {
                    System.out.println("t1 entering...have lock1");
//                    try {
//						Thread.sleep(3000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					synchronized(lock2){
						System.out.println("t1 have lock2...");
						
					}
					
				}
			}
		}

				, "t1");
		
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				synchronized (lock2) {
					 System.out.println("t2 entering...have lock2");
						synchronized(lock1){
							System.out.println("t2 have lock1...");
						}
				}
			}
		}

				, "t2");
		
		t1.start();
		t2.start();
		
	}

}