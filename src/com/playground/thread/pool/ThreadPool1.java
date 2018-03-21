package com.playground.thread.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月16日 下午4:25:41
 * 
 * 
 * 尝试使用jdk的ThreadPool
 * 
 * 可以看到即便new了20次对象，打印出来的线程数也只有8个。 newFixedThreadPool的核心和最大线程都是8
 * 
 * 线程池包揽了线程的创建、存储、调度、销毁
 * 
 * 如果执行了线程池的prestartAllCoreThreads()方法，线程池会提前创建并启动所有核心线程。   然而这个方法我压根不知道是谁的。。
 */

public class ThreadPool1 {
	
	private static Executor executor = Executors.newFixedThreadPool(8);
	public static void main(String[] args) {
		for(int i=0;i<20;i++)
		   executor.execute(new Task());
	}
	
	static class Task implements Runnable{
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
		
	}
	

}
