package com.playground.thread.juc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月27日 下午4:08:12
 * 
 * 测试copyOnWriteArrayList
 * 
 * 将所有Thread构造替换成ArrayList  就会报java.util.ConcurrentModificationException
 *       
 *  cow不适合实时读取数据      
 * 
 */

public class TestCopyOnWrite {
	
	public static void main(String[] args) {
		//1. 初始化CopyOnWriteArrayList 
		List<Object> list = Arrays.asList(new Integer[] {1,2});
//		ArrayList<Object> tmpList = new ArrayList<>(list);
		CopyOnWriteArrayList<Object> cow = new CopyOnWriteArrayList<>(list);
		
		//2. 模拟多线程对list进行读和写
		ExecutorService pool = Executors.newCachedThreadPool();
		pool.execute(new ReadThread(cow));
		pool.execute(new WriteThread(cow));
		pool.execute(new ReadThread(cow));
		pool.execute(new ReadThread(cow));
		pool.execute(new WriteThread(cow));
		pool.execute(new WriteThread(cow));  //结束后长度应该为5
		
//		pool.execute(new ReadThread(tmpList));
//		pool.execute(new WriteThread(tmpList));
//		pool.execute(new ReadThread(tmpList));
//		pool.execute(new ReadThread(tmpList));
//		pool.execute(new ReadThread(tmpList));
//		pool.execute(new WriteThread(tmpList));
//		pool.execute(new WriteThread(tmpList));
//		pool.execute(new WriteThread(tmpList));  //结束后长度应该为6
		
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			System.out.println("CopyOnWrite: "+cow.size());
//			System.out.println("CopyOnWrite: "+tmpList.size());
			pool.shutdown();
			//关闭线程池之后，我们看看list里面的值
			for(Object i: cow){
				System.out.print(i+"/");
			}System.out.println();
			
			//我们在线程池之后开启一个线程
			Thread t1 = new Thread(new ReadThread(cow));
			t1.start();
			//发现在cow并发操作完成之后单开一个线程是能够完美读取数据的，证明cow不适合实施读取
		}
		
		
	}
	
}


class WriteThread implements Runnable{
   
	
	private List<Object> list;
	public WriteThread(List<Object> list){
		this.list = list;
	}
	
	
	@Override
	public void run() {
		list.add("9");
//		System.out.println(Thread.currentThread().getName()+" Write 一个9。");
	}
}

class ReadThread implements Runnable{
	
	private List<Object> list;

	public ReadThread(List<Object> list){
		this.list = list;
	}
	
	@Override
	public void run() {
		for(int i=0;i<list.size();i++)
			System.out.println(Thread.currentThread().getName()+">> ReadThread: "+"  listSize = "+list.size()+" 元素: "+list.get(i));  //为什么这里没有重复读9呢？
		
	}
}