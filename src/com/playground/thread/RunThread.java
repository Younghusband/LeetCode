package com.playground.thread;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月5日 下午6:55:13
 * 
 * 引入 volatile概念
 * 
 * 如果不加volatile  	: run方法不会停止，同时查看isRunning的值为false (主内存)
 * 加了volatile     	: run方法3秒后停止。  
 * 
 * 思考循环体内的注释
 */

public class RunThread extends Thread{
	
	/* volatile   */
	private volatile boolean isRunning = true;
	
	private void setRunning(boolean flag){
		this.isRunning = flag;
	}
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+"进入run方法..");
		while(isRunning==true){
			
			//System.out.println("----");    //这个会干扰线程工作的状态，导致不加volatile的情况下也会跳出循环
			
		}
		System.out.println(Thread.currentThread().getName()+"线程停止");
	}
	
	public static void main(String[] args) throws Exception{
		RunThread rt = new RunThread();
		rt.setName("t1");
		rt.start();
		Thread.sleep(3000);
		rt.setRunning(false);
		System.out.println("isRunning的值已被设置为false");
		Thread.sleep(1000);
		System.out.println("isRunning的值为"+rt.isRunning);
	}

}
