package com.playground.jvm;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月10日 下午9:42:54
 * 
 * Xss
 * 
 */

public class Test04 {
	//Xss1m     count=18624
	//Xss5m     count=127254
	
	//栈调用深度
	private static int count;
	
	public static void recursion(){
		count++;
		recursion();
	}
	
	public static void main(String[] args) {
		try{
			recursion();
		}catch(Throwable t){
			System.out.println("调用最大深度:"+count);
			t.printStackTrace();
		}
		
	}
	
	

}
