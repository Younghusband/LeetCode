package com.playground.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月5日 下午8:02:36
 * 
 * 此类的两个作用，引入atomic类。同时对比发现volatile并不具有原子性的特征
 * 
 * 使用volatile的情况下:
 *      出现的结果有最大值不是10000的情况，即证明其不具有原子性。
 * 使用atomic类就没这个问题。     
 * 
 */

public class VolatileNotAtomic extends Thread{
//	private static volatile int count;
	private static AtomicInteger count = new AtomicInteger(0);
	
	private static void addCount(){
		for(int i = 0;i < 1000; i++){
//		    count++;
		    count.incrementAndGet();
		}
		System.out.println(count);
	}
    public void run(){
    	addCount();   //非静态方法内调用静态方法
    }
    
    public static void main(String[] args) {
		
    	VolatileNotAtomic[] arr = new VolatileNotAtomic[10];
    	for(int i = 0; i < 10; i++){
    		arr[i] = new VolatileNotAtomic();
    	}
    	
    	for(int i = 0; i < 10; i++){
    		arr[i].start();
    	}
    	
	}
    

}
