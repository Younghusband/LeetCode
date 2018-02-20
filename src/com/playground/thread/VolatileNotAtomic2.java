package com.playground.thread;

import java.util.concurrent.TimeUnit;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月20日 下午1:15:06
 * 
 * 
 * 这是volatile做不到的地方，结果不能保证一定得到1000. 
 */

public class VolatileNotAtomic2 {
	
	public static volatile int count=0;
	
	
	public static void main(String[] args) {
		
		for(int i=0;i<10;i++){
			new Thread(
					new Runnable(){
						public void run(){
								try {
									TimeUnit.MILLISECONDS.sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								for(int i=0;i<100;i++){
									count++;
								}
						}
					}
					).start();
			
		}
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(count);
	}

}
