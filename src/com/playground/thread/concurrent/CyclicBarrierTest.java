package com.playground.thread.concurrent;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月18日 下午8:03:31
 * 
 * 
 * CyclicBarrier 用法初尝试  结合王者荣耀
 * 
 * 王者峡谷5个人，不集合之前都是await()  所有人都await()之后开始团战，代码接着走
 * 
 * 栅栏用于等待其它线程，且会阻塞自己当前线程；
   所有线程必须同时到达栅栏位置后，才能继续执行；
   
   CyclicBarrier自身构造中有runnable 里面可以放所有线程等待完毕后想执行的业务代码
   
   CyclicBarrier(int parties, Runnable r) ...
   
 */

public class CyclicBarrierTest {
	
	private static final int THREAD_NUM = 5;
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUM);
		CyclicBarrier barrier = new CyclicBarrier(THREAD_NUM, new Runnable() {   //注意构造的写法
			public void run() {
                  System.out.println("-------*----------$# BOOM  BOOM  BIUBIUBIU-------*----------$#");
			}
		});
		
//		PrepareTask task = new PrepareTask(barrier);
		
		for(int i=1;i<=THREAD_NUM;i++){
			pool.execute(new PrepareTask(barrier));
//			pool.execute(task);   //多个runnable启动线程，和一个runnable怼进多个线程有什么区别？
			
		}
		
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			pool.shutdown();
		}
		
		while(true){  //线程池关闭后的后续处理
			if(pool.isTerminated()){
				System.out.println(">>>>>>>>>>>> Victory! <<<<<<<<<<<\n");
				System.out.println("----------------END----------------");
				break;
			}
		}
		
	}

}

class PrepareTask implements Runnable{
	private CyclicBarrier c;
	Random r;
	public PrepareTask(CyclicBarrier c){
		this.c = c;
		r = new Random();
	}
	
	@Override
	public void run() {
		try {
			SemaphoreTest.print(" 正在前往支援！！");
			TimeUnit.SECONDS.sleep(r.nextInt(10));
			SemaphoreTest.print(" 赶到战场，草丛埋伏~");
			c.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("团战结束，各自发育。。。");
	}
	
	
}
