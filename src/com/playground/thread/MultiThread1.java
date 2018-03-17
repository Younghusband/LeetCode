package com.playground.thread;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月3日 下午8:09:10
 * 
 * 思考:
 * 
 * 1. 当方法没有static的时候 为什么结果始终num=200
 * 2. 明确两个static分别的作用
 *
 * 当多个对象对一个方法进行竞争的时候，方法不加 类锁(static synchronized) 则各执行各的
 *
 */

public class MultiThread1 {
	
	/**static */
	private static int num =0;
	
	/**static */
	public synchronized void printNum(String tag){
		
		try {
		if("a".equals(tag)){
			   System.out.println("--------a---------");
			   num = 100;
			   System.out.println("tag a, set num over");
			   Thread.sleep(5000);
		   }else{
			   System.out.println("--------b---------");
			   num = 200;
			   System.out.println("tag b, set num over");
			   
		   }
			System.out.println("tag = "+tag+"  num = "+num);   // b先执行完
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		 final MultiThread1 my1 = new MultiThread1();  //这里为什么加final
		 final MultiThread1 my2 = new MultiThread1();
		
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				my1.printNum("a");
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				my2.printNum("b");
			}
		},"t2");
		
		
		t1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}
	

}
