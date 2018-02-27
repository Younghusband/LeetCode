package com.playground.thread.conn.abc;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月27日 下午4:28:30
 * 
 * 实现三个线程依次打印的效果。。
 * 
 * 利用synchronized实现
 * 
 * 在这里notify或者notifyall执行起来并没有区别
 */

public class ABC implements Runnable{
	private Object pre;
	private Object self;
	
   public ABC(Object pre,Object self){
	   this.pre = pre;
	   this.self = self;
   }
	

	@Override
	public void run() {
		int count = 10;
		while(count>0){
			synchronized(pre){
				synchronized(self){
						System.out.println(Thread.currentThread().getName()+"---"+count--);
						self.notifyAll();   //如果换成notify会怎么样
//						self.notify();
				}
				
						try {
							Thread.sleep(1000);
							pre.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Object lockA = new Object();
		Object lockB = new Object();
		Object lockC = new Object();
		
		ABC one = new ABC(lockC,lockA);
		ABC two = new ABC(lockA,lockB);
		ABC three = new ABC(lockB,lockC);
		
		Thread A = new Thread(one,"A");
		Thread B = new Thread(two,"B");
		Thread C = new Thread(three,"C");
		
		
			try {
				A.start();
				Thread.sleep(1); 
//				t1.join();  //不能使用join，如果这里使用join的话。会等t1执行完毕
				B.start();
				Thread.sleep(1);
				C.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	
	
	
	
}
