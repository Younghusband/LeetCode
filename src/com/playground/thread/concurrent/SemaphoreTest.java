package com.playground.thread.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月18日 下午5:11:57
 * 
 * 测试Semaphore的用法
 * 
 * 举个例子，如下代码，十个线程竞争三个资源，一开始有三个线程可以直接运行，剩下的七个线程只能阻塞等到其它线程使用资源完毕才能执行
 * 
 * 这就是Semaphore的威力
 * 
 * 这里的例子:   厕所一共3个坑位，10个人上厕所
 */

public class SemaphoreTest {
	
	private static final int THREAD_NUM = 10;
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUM);  //10个线程
		Semaphore s = new Semaphore(3);   //3个坑位
		
		
		for(int i=1;i<=THREAD_NUM;i++){
			pool.execute(new SourceThread(s));
		}
		
		try {
			TimeUnit.SECONDS.sleep(30);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.shutdown();
		}
		
		while (true) { 
			if (pool.isTerminated()) { //线程池shutdown之后
				System.out.println("---END---\n");
				System.out.println("所有的子线程都结束了！");
				break;
			}

		}
	}
	
	
	public static void print(String str){
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		System.out.println("["+format.format(new Date())+"]  "+Thread.currentThread().getName()+" "+str);
	}

}

class SourceThread implements Runnable{
    
	private Semaphore s;
	Random r = new Random();
	
	public SourceThread(Semaphore s){
		this.s = s;
	}
	
	@Override
	public void run() {
	    SemaphoreTest.print(" 排队蹲坑。。。");
	    try {
			s.acquire();
			//下面3行为实际你要处理的业务，这里用蹲坑模拟
			SemaphoreTest.print(" 占领坑位！！！！");
			TimeUnit.SECONDS.sleep(r.nextInt(10));
			SemaphoreTest.print(" 拉完屎出坑。");
			s.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
