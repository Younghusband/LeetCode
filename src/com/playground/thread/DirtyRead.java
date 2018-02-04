package com.playground.thread;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月3日 下午9:45:36
 * 
 *   业务脏读
 *   思考
 *   1. 为什么get方法加了synchronized就不会脏读了呢
 *      
 *      答: 是不是因为对于一个对象来说，对象内的所有带有synchronized的方法都共享一把锁 
 *          详见test()方法，如果主线程调用test()方法滞后了3秒，就说明是这个道理。
 *   
 */

public class DirtyRead {
	
	private String user = "root";
	private String password = "12345";
	
	public synchronized void setValue(String u, String p){
//		System.out.println("setValue方法获得的数据:  user = "+u+" password = "+p);
	    System.out.println(Thread.currentThread().getName()+"-----------------------------------------------");  //只是为了看main线程和t1线程谁跑在前面
		this.user = u;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.password = p;
		
	}
	
	/**synchronized */
	public synchronized void getValue(){  //不加synchronized就会产生脏读
		System.out.println(Thread.currentThread().getName() +": getValue方法获得的数据:  user = "+user+" password = "+password);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void test(){
		System.out.println("test方法----------------------------");
	}
	
	public static void main(String []args){
		final DirtyRead dirty = new DirtyRead();
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				dirty.setValue("yf", "fuckyou");
			}
		},"t1");
		
		t1.start();
		try {
			Thread.sleep(500);   // 如果不加这个，则有可能直接读出未修改的数据
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dirty.getValue();   //这个时候应该读到yf, fuckyou 这一套值才对
		
		dirty.test();
		
	}

	
	
}
