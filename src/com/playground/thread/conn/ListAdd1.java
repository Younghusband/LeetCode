package com.playground.thread.conn;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月20日 下午3:39:32
 * 
 * 初步实践线程通信，低端  无notify wait等方法
 * 
 * 思考
 * 1. 为什么list加了static不加volatile的话线程之间仍不可见？
 * 
 */

public class ListAdd1 {
	
	/*volatile */
	private volatile List list = new ArrayList();
	
	public void add(){
		list.add("yf");
	}
	
	public int size(){
		return list.size();
	}

	public static void main(String[] args) throws Exception {
		final ListAdd1 listObj = new ListAdd1();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						listObj.add();
						System.out.println(Thread.currentThread().getName() + "-----");
						Thread.sleep(500);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + "-----进入-----状态是-----" + Thread.currentThread().getState());
				while (true) {
					if (listObj.size() == 5) {
						throw new RuntimeException("线程个屁");
					}
				}
			}
		}, "t2");

		t1.start();
		t2.start();

	}
	
	
	
}
