package com.playground.thread.conn.abc;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月27日 下午5:57:01
 * 
 * 利用等待时间差
 * 
 * 太小的等待时间 10，15，20 这样就不能保证ABC
 * 100，105，120 就没问题
 * 
 * 这种方式我无法保障。。
 */

public class ABCSimple {
	
	public static void main(String[] args) {
		A1 t1 = new A1();
		A2 t2 = new A2();
		A3 t3 = new A3();
		
		t1.setName("A");
		t2.setName("B");
		t3.setName("C");
		
		t1.start();
		t2.start();
		t3.start();
	}

}

class A1 extends Thread{
	
	public void run(){
		int count = 3;
		while(count>0){
		try {
			Thread.sleep(1001);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("A");
		count--;
		}
	}
	
}

class A2 extends Thread{
	
	public void run(){
		int count = 3;
		while(count>0){
		try {
			Thread.sleep(1002);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("B");
		count--;
		}
	}
	
}

class A3 extends Thread{
	public void run(){
		int count = 3;
		while(count>0){
		try {
			Thread.sleep(1003);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("C");
		count--;
		}
	}
}