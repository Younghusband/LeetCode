package com.playground.jvm;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月10日 下午3:27:31
 * 
 * 
 * 
 */

public class Test01 {
	
	public static void main(String[] args) {
		
		
		//-XX:+UseCompressedOops  -XX:-UseLargePagesIndividualAllocation
		
		//-Xms5m  -Xmx20m  -XX:+UseSerialGC  -XX:+PrintGCDetails -XX:+PrintCommandLineFlags
		
		//如果不设置的话 默认初始化堆内存64M   最大堆内存1G
		
		System.out.println("Max Memory:"+ Runtime.getRuntime().maxMemory());    //和设置的20M一致
		System.out.println("Free Memory:"+ Runtime.getRuntime().freeMemory());  //系统会吃掉一些，小于5M
		System.out.println("Total Memory:"+ Runtime.getRuntime().totalMemory());  //这个是和设置的5M一致
		
		byte [] b1 = new byte[1*1024*1024];   //先用掉1M
		
		System.out.println("分配了1M");
		System.out.println("Max Memory:"+ Runtime.getRuntime().maxMemory());
		System.out.println("Free Memory:"+ Runtime.getRuntime().freeMemory());
		System.out.println("Total Memory:"+ Runtime.getRuntime().totalMemory());
		
		byte [] b2 = new byte[4*1024*1024];   //再用掉4M
		
		System.out.println("分配了4M");
		System.out.println("Max Memory:"+ Runtime.getRuntime().maxMemory());
		System.out.println("Free Memory:"+ Runtime.getRuntime().freeMemory());
		System.out.println("Total Memory:"+ Runtime.getRuntime().totalMemory());
		
		int a = 0x00000000fa0a0000;
		int b = 0x00000000fa801000;
		System.out.println("结果为:"+(b-1)/1024);
		
	}

}
