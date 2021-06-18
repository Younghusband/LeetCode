package com.playground.thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年4月2日 下午8:10:15
 * 
 * submit()方法会产生Future对象，它用Callable返回结果的特定类型进行了参数化。
 * 可以用isDone()方法来查询Future是否已经完成，当任务完成时，它具有一个结果，可以调用get()方法获取该结果。
 * 也可以不用isDone()进行检查就直接调用get()，在这种情况下，get()将阻塞，直至结果准备就绪。
 * 还可以在试图调用get()来获取结果之前，调用具有超时的get()。
 */

public class UseCallableDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newCachedThreadPool();
		//用于接收返回值
		List<Future<String>> resultList = new ArrayList<>();
		//每一次submit的返回结果放入Future对象的list里
		for(int i = 0; i < 5; i++){
			resultList.add(pool.submit(new TaskWithResult(i)));
			TimeUnit.SECONDS.sleep(1);
			//这样的话应该是休眠5秒  然后返回一个值
		}
		
		//逐个获取返回值
		for(Future<String> item : resultList){
			if(item.isDone()) {
				System.out.println("准备就绪");
			}
			System.out.println(item.get());
		}
		
	}
	
	

}

class TaskWithResult implements Callable<String>{
    
	private int id;
	public TaskWithResult(int id){
		this.id = id;
	}
	
	@Override
	public String call() {
		return "TaskWithResult  No:"+id;
	}
	
	
	
	
}
