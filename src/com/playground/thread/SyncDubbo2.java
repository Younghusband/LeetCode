package com.playground.thread;

/**
 * @description
 * @author vermouth.Mac
 * @version 2018年2月4日 下午6:01:20
 * 
 * synchronized的重入  
 * 
 * 执行效果是  交替减1
 * 
 * 问题:  
 *    把注释打开，看看多线程下的效果。 思考为什么会出现(只有一个线程能执行的情况)
 *    
 * 答:
 *    静态内部类，锁死了。 不存在线程安全问题   
 */

public class SyncDubbo2 {

	static class Main {
		public int i = 10;
		public synchronized void operationMain() {
			try {
				i--;
				System.out.println("Main print i = " + i+ "  "+Thread.currentThread().getName());
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	  static class Sub extends Main {
		public synchronized void operationSub() {
			try {
				while (i > 0) {
					i--;
					System.out.println("Sub print i = " + i+ "  "+Thread.currentThread().getName());
					Thread.sleep(100);
					this.operationMain();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Sub sub = new Sub();
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				sub.operationSub();
			}
			
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				sub.operationSub();
			}
			
		},"t2");
		
		t1.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
//		sub.operationSub();
		
	}
	
	

}
