package com.playground.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年4月2日 下午6:54:20
 * 
 * 
 * 这种方式的问题在于，我不明白为什么要绕一个大圈子最后得到普通implements Runnable的效果
 * 
 * 并没有体现callable的特性，带有返回值
 */

public class UseCallable {

	
	public static void main(String[] args) {
		//创建一个callable
		Task1 callableTask = new Task1();
		//用futureTask包装器
		FutureTask future = new FutureTask(callableTask);
		Thread t = new Thread(future);
		t.start();
	}
	
	
}



class Task1 implements Callable {
	@Override
	public Object call() {
		System.out.println(Thread.currentThread().getName()+"-------");
		return 1;
	}
	
	
}