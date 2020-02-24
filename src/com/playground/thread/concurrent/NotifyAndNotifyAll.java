package com.playground.thread.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月27日 下午6:56:54
 * 
 * 
 * 使用notify时：
 *      只有一个Thread会被唤醒，其余Thread还处于等待中，所以程序并不能在Main End之后结束。
 * 使用notifyall时:
 *      所有等待的线程都会被唤醒，所以程序能够结束。     
 * 
 */

public class NotifyAndNotifyAll {
	
	public static void main(String[] args) {
		Object co = new Object();
		for(int i=1;i<=4;i++){
			new MyThread1("Thread"+i,co).start();
		}
		
		try {
			TimeUnit.SECONDS.sleep(2);
			System.out.println("-----------Main Thread notify----------");
			synchronized(co){
//			    co.notify();      //随便唤醒一个
			    co.notifyAll();   //唤醒Thread1 - 4
			}
			TimeUnit.SECONDS.sleep(2);
			System.out.println("-----------Main Thread End----------");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    		
	}
	
	

}

class MyThread1 extends Thread{
	private String name;
	private Object lock;
	
	public MyThread1(String name,Object lock){
		this.name = name;
		this.lock = lock;
	}
	
	@Override
	public void run(){
		System.out.println(this.name+"  waiting....");
		synchronized(lock){
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.name+" 被唤醒！！！");
		}
	}
	
	
	
	
}