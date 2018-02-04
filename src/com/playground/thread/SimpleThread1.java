package com.playground.thread;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月3日 下午5:12:25
 * 
 * 思考
 * 1.  为什么方法去掉了synchronized之后  虽然过程是乱的，但为什么结果能得到0
 * 2.  如果五个线程传入不同的SimpleThread1类，那么执行效果如何 (混乱)
 */

public class SimpleThread1 extends Thread{
	
	private int count=5;
	
	/***synchronized **/
	
    public synchronized void run(){
    	count--;
    	System.out.println(this.currentThread().getName()+" count ="+ count);
    }
	

	
	public static void main(String[] args) throws Exception{
	     SimpleThread1 s1 = new SimpleThread1();
	     SimpleThread1 s2 = new SimpleThread1();
         Thread t1 = new Thread(s1);
         Thread t2 = new Thread(s1);
         Thread t3 = new Thread(s1);
         Thread t4 = new Thread(s1);
//         Thread t3 = new Thread(s2);
//         Thread t4 = new Thread(s2);
         Thread t5 = new Thread(s1);
	     
         t1.start();
         t2.start();
         t3.start();
         t4.start();
         t5.start();
         
	}
	
	
	
	
	
	

}
