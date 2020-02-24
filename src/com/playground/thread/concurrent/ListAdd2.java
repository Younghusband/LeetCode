package com.playground.thread.concurrent;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月24日 下午5:40:28
 * 
 * 使用Object类的wait和notify来实现线程通信
 * wait和notify不适合即时通信。 且循环里面千万不要用notify。 notify会等循环结束才会通知到对方
 * 
 * 循环里面不要用notify!!!!
 * 
 * 
 * 1.  wait如果不在synchronized里面的话，编译没问题。运行会报IllegalmonitorStateException
 * 2.  wait和notify如果不指名对象的话，调用的是哪个对象？  (lock.wait 和单独用wait)
 * 3.  wait释放锁，notify不释放锁
 * 4.  如果没有notify,wait的线程永远醒不来，哪怕别的同步块已经释放了锁
 * 
 * 
 * CountDownLatch 跟锁没有关系。
 * 
 *  单纯用wait,notify实现的功能请见ListAdd3.java
 */

public class ListAdd2 {
     
	   private volatile int count=0;
	   public void add(){
		   count++;
		   System.out.println(Thread.currentThread().getName()+"----------"+count);
	   }
	   public int size(){
		   return this.count;
	   }
	
	
	   public static void main(String[] args) {
		ListAdd2 obj = new ListAdd2();
		final Object lock = new Object();
//		final CountDownLatch countDown = new CountDownLatch(1);
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + "进来了。");
				try {
					synchronized (lock) {
						for (int i = 0; i < 10; i++) {
							obj.add();
							if (obj.size() == 5) {
								System.out.println("发出通知。");
								lock.notify(); // notify不释放锁，循环结束之前对方无法被唤醒
//								countDown.countDown();
							}
							Thread.sleep(500);
						}
					 }
						System.out.println("走出t1同步块。");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}, "t1");
		   
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName()+"进来了。");
				try {
					synchronized (lock) {
//					    Thread.sleep(5000);   //如果开开，t2的for循环就得5秒后才能执行
					    lock.wait();
//					    countDown.await();
					    System.out.println("沉睡的t2被唤醒了！");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t2");
		   
		t2.start();
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();
		
	}
	
}
