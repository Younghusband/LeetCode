package com.playground.thread.lock;

import java.util.concurrent.TimeUnit;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月25日 下午7:27:41
 * 
 * 通过对业务更深的理解，将锁的粒度优化至最小。
 * 
 * 这大概就是乐观锁吧
 * 
 */

public class Optimize {

	public void doLongTimeTask() {
		try {
			System.out.println(Thread.currentThread().getName() + "线程正在执行一个非常耗时的任务，不需要同步。");
			TimeUnit.MINUTES.sleep(2);
			synchronized (this) {
				System.out.println(Thread.currentThread().getName() + "当前线程正在执行同步代码块对核心内容进行修改...");
				TimeUnit.SECONDS.sleep(2);
			}
			System.out.println(Thread.currentThread().getName() + "线程执行完毕。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void doShortTimeTask() {
		try {
			synchronized (this) {
				System.out.println(Thread.currentThread().getName() + "当前线程正在执行同步代码块对核心内容进行修改...");
				TimeUnit.SECONDS.sleep(2);
			}
			System.out.println(Thread.currentThread().getName() + "线程执行完毕。");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void main(String[] args) {
		final Optimize opt = new Optimize();
        Thread t1 = new Thread(
        		new Runnable(){
        			public void run(){
        				opt.doLongTimeTask();
        			}
        		},"t1");
		
        Thread t2 = new Thread(
        		new Runnable(){
        			public void run(){
        				opt.doShortTimeTask();
        			}
        		},"t2");
        
        t1.start();
        t2.start();        
        
	}
	
	
	
	
}
