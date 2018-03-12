package com.playground.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月10日 下午9:47:34
 * 
 * 测试新生代晋升老年代的问题
 */

public class Test05 {
	
	public static void main(String[] args) {
		//出事的对象在eden区
		//参数: -Xmx64m  -Xms64m  -XX:+PrintGCDetails
	    // eden 16M from+to 5M tenure 43M
//		for(int i=0; i<5; i++){
//			byte [] b= new byte[1*1024*1024];
//		}  //会显示eden区16M 使用了40%左右  没毛病
		
		
		//测试进入老年代的对象
		
		//参数: -Xmx1024m -Xms1024m -XX:+UseSerialGC -XX:MaxTenuringThreshold=15 -XX:+PrintGCDetails
		//-XX:+PrintHeapAtGC
		Map<Integer, byte[]> m = new HashMap<Integer, byte[]>();
		for(int i=0; i<5;i++){
			byte [] b = new byte[1024*1024];
			m.put(i, b);
		}  //之所以放到map里，是使得这个5M的对象一直被持有，不会被GC淘汰
		
		for(int k=0; k<20; k++){
			for(int j=0; j<300; j++){
				byte[] b = new byte[1024*1024];
			}
		} // 然后在这个过程中，由于超过了1G 会不断的GC，直到GC15次以后，上面的map会晋升老年代
		
		
	}

}
