package com.playground.thread.juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月18日 下午2:01:17
 */


class TestTask implements Runnable{
    
	private CountDownLatch latch;
	private int sleeptime;
	
	public TestTask(CountDownLatch latch, int sleeptime){
		this.latch = latch;
		this.sleeptime = sleeptime;
	}
	
	
	@Override
	public void run() {
		try {
			CountDownLatchTest.print("entering...");  //10个线程是乱序打印这句
			TimeUnit.SECONDS.sleep(sleeptime);
			CountDownLatchTest.print("finished!!!!!");    //10个线程依次打印这句
			TimeUnit.SECONDS.sleep(1);  //每个线程延迟一秒countDown
			latch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}





public class CountDownLatchTest {
	
	private static final int THREAD_NUM = 10;
	
	public static void main(String[] args){
		ExecutorService cachePool = Executors.newFixedThreadPool(THREAD_NUM);
		final CountDownLatch latch = new CountDownLatch(THREAD_NUM);
		for (int i = 1; i <= THREAD_NUM; i++) {
			cachePool.execute(new TestTask(latch, i));
		}
		
		try {
			latch.await(); // 10个线程执行完毕后悔调用下面
			CountDownLatchTest.print(">>>>>Continued...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			cachePool.shutdown();
		}
		
	}
	
	
	
	public static void print(String str){
		SimpleDateFormat date = new SimpleDateFormat("HH");
		System.out.println("["+date.format(new Date())+"]"+Thread.currentThread().getName()+"  "+str);
	}

}
