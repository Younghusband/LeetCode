package com.playground.thread.lock;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月25日 下午6:14:59
 * 
 * 对比changeLock
 * 
 * 锁本身的改变(change)是会导致锁失效的，但锁属性的改变不影响锁(modify)
 * 
 * 直接加在方法上的synchronized代表着给调用的对象加锁，是对象锁。
 * 
 * 利用join方法控制线程执行的顺序。
 */

public class ModifyLock {
     int age;
     String name;
     private Object obj = new Object();
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
     
	/**
	 * 如果锁生效的话: 线程1更改age，name后线程2进入
	 * 如果失效的话  : 线程1，2同时进入
	 * 
	 * */
	public synchronized void setAttribute(int age,String name) throws InterruptedException{
		System.out.println(Thread.currentThread().getName()+"-----START-----"+Thread.holdsLock(obj)); //Object并没有作为锁，所以为false
		setAge(age);
		setName(name);
		System.out.println(Thread.currentThread().getName()+"-----修改对象属性为-----   "+this.getName()+","+this.getAge());
		Thread.sleep(3000);
		System.out.println(Thread.currentThread().getName()+"-----END-----"+Thread.holdsLock(this));  //true 同步块内都算hold锁
	}
	
	
	
	public static void main(String[] args) {
		final ModifyLock obj = new ModifyLock();
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				try {
					obj.setAttribute(10, "杨帆");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try {
					obj.setAttribute(20, "傻逼");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		},"t2");
		
		try {
			t1.start();
			t1.join();
			Thread.sleep(1);
			t2.start();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//反应的 应该是线程2修改后的结果  "傻逼"
		System.out.println(obj.getName());   //如何让主线程在俩线程执行完毕后再执行呢。 让别的线程调用join方法
		
	}
	
	
	
}
