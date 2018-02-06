package com.playground.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月5日 下午8:38:45
 * 
 * Atomic的用法。
 * Atomic能保证单次操作的原子性，但多次操作并不具有原子性。 仍需要synchronized
 * 
 * 思考这种多线程的程序如何计时的问题。（毕竟如果主线程计时的话，不能保证头尾）
 */

public class AtomicUse {
	private static AtomicInteger count = new AtomicInteger(0);
	/* synchronized */
	public int multiAdd(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count.addAndGet(1);
		count.addAndGet(2);
		count.addAndGet(3);
		count.addAndGet(4);    //如果原子性不被打破的话，结果必然都是10的整数倍
		return count.get();
	}
	
	public static void main(String[] args) {
		final AtomicUse au = new AtomicUse();
		List<Thread> threadlist = new ArrayList<Thread>();
		for(int i=0;i<100;i++){
			threadlist.add(new Thread(new Runnable(){
				public void run(){
					System.out.println(au.multiAdd());
				}
			},"t"
			));
		}
		for(Thread t:threadlist){
			t.start();
		}
		
	}
	

}
