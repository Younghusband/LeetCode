package com.playground.thread;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月5日 上午10:52:56
 * 
 * 线程终止的方式之一
 * 
 * System.out.println() 对程序实验有影响
 */

public class ThreadFlag extends Thread{
	// 即便是单个线程，这里也有必要volatile 想想为什么
	private volatile boolean flag = false;
	
	@Override
	public void run(){
		while(!flag){
//			System.out.println(Thread.currentThread().getName()+"---------");
		}
	}
	
	public void exit(){
		this.flag = true;
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadFlag thread1 = new ThreadFlag();
		
		thread1.start();
		Thread.sleep(3000);
		thread1.exit();
		
	}

}
