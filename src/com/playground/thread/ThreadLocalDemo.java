package com.playground.thread;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月6日 下午7:46:49
 * 
 * 不使用ThreadLocal的话，各线程仍能获取到同一个对象的变量
 * 
 * ThreadLocal是怎样的一个数据结构
 */

public class ThreadLocalDemo {
	public ThreadLocal<String> th = new ThreadLocal<String>();
	public void set(String str){  
		th.set(str);
	}
	
//	public void set(String str){ //不使用ThreadLocal
//		this.name = str;
//	}
	
	public void get(){  
		System.out.println(Thread.currentThread().getName()+" 获取到  "+th.get());
	} 
	
//	public void get(){ //不使用ThreadLocal
//		System.out.println(Thread.currentThread().getName()+" 获取到  "+name);
//	}
	
	
	
	public static void main(String[] args) {
		final ThreadLocalDemo obj = new ThreadLocalDemo();
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				obj.set("yf");
				obj.get();
			}
			
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try {
					Thread.sleep(2000); //确保t1执行完后 t2才获取
				} catch (InterruptedException e) {
					e.printStackTrace();
				}  
				obj.get();
			}
		},"t2");
		
		t1.start();
		t2.start();
		
	}
	
}
