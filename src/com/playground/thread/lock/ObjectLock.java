package com.playground.thread.lock;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月25日 下午6:13:04
 * 
 * 测试加锁的几种方式
 * 
 * 见main方法
 * 结论:
 * 1. 对整个方法上synchronized相当于对当前对象加锁
 * 2. 类锁和对象锁互相不影响，可以同时执行
 * 3. 同一个对象两个线程调用类锁互斥
 * 
 * 既然可以利用join控制线程执行顺序
 */

public class ObjectLock {
	
	public void method1(){
		synchronized(this){  //对象锁
			try {
				System.out.println(Thread.currentThread().getName()+" do method1..");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void method2(){
		synchronized(ObjectLock.class){  //类锁
			try {
				System.out.println(Thread.currentThread().getName()+" do method2..");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Object lock = new Object();
	public void method3(){
		synchronized(lock){  //给定对象的锁
			try {
				System.out.println(Thread.currentThread().getName()+" do method3..");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public synchronized void method4(){  //应该等同于method1
			try {
				System.out.println(Thread.currentThread().getName()+" do method4..");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	
	public static void main(String[] args) {
		ObjectLock obj = new ObjectLock();
		
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				obj.method1();  //当前对象锁
//				obj.method2();  //类锁
//				obj.method3();  //外部对象锁
//				obj.method4();  // 对整个方法加锁  相当于当前对象锁
			}
		},"T1");
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
//				obj.method1();  //当前对象锁
//				obj.method2();  //类锁
				obj.method3();  //外部对象锁
//				obj.method4();  // 对整个方法加锁  相当于当前对象锁
			}
		},"T2");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//通过两个join保证了 t1 t2的先后执行的同时确保了main线程最后执行
		System.out.println(Thread.currentThread().getName()+"-------END-------"); 
		
		
		
	}
	

}
