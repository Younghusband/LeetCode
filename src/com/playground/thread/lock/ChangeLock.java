package com.playground.thread.lock;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月25日 下午4:32:10
 * 
 * 改动原有的锁，会怎样
 * 
 * 效果是:
 *   1. 如果中途不将锁的值改变，则线程2走完之后线程1才start
 *   2. 如果中途把锁改变了，线程12可以同时start
 *   
 *   以下针对lock="b";这一行
 *   
 *   1. 放在synchronized外面，相当于两个线程都用"b"这个锁，同步没有问题。
 *   2. 放在START上面或是下面一行。都会导致锁失效
 *   3. 放在Sleep(3000)下面，均能使T2执行完之后才执行T1
 */

public class ChangeLock {
	
	private String lock = "a";
	
	
	//会让两个线程调用这个方法
	public void method(){
		synchronized(lock){
			try {
				lock = "b";  //开启锁就会失效
				System.out.println(Thread.currentThread().getName()+"----"+"START"+"  lock:"+lock);  //打印两个线程各自持有的锁
				Thread.sleep(3000);
				System.out.println(Thread.currentThread().getName()+"----"+"END");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		ChangeLock obj = new ChangeLock();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				obj.method();
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				obj.method();
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
