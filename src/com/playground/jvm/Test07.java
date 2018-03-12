package com.playground.jvm;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月12日 下午3:16:37
 * 
 * 查看TLAB对于小对象的创建性能提升。
 * 
 * 表现为:  -XX:-UseTLAB 会比  -XX:+UseTLAB慢很多
 * 
 */

public class Test07 {
	
	public static void alloc(){
		byte [] b = new byte[2];
	}
	
	public static void main(String [] args){
		long start = System.currentTimeMillis();
		
		//TLAB分配
		//参数: -XX:+UseTLAB -XX:+PrintTLAB -XX:+PrintGC -XX:TLABSize=102400 -XX:-ResizeTLAB -XX:TLABRefillWasteFraction=100  -XX:-DoEscapeAnalysis -server
		for(int i=0; i<10000000; i++){
			alloc();
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	

}
