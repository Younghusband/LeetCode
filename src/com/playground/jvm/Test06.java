package com.playground.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月12日 上午11:32:13
 * 
 * 测试  -XX:PretenureSizeThreshold=1000  和 TLAB
 */

public class Test06 {
	
	
	/**
	 *    -XX:+UseTLAB   使用TLAB
		  -XX:+TLABSize  设置TLAB大小
		  -XX:TLABRefillWasteFraction  设置维护进入TLAB空间的单个对象大小，他是一个比例值，默认为64。即如果对象大于整个空间的1/64, 则在堆创建对象。
		
		  -XX:PrintTLAB  查看TLAB信息  必须禁用逃逸分析参数才能使用
		  -XX:ResizeTLAB  自调整TLABRefillWasteFraction阀值
	 * 
	 * 
	 * */
	
	
	
	public static void main(String[] args) {
		//参数: -Xmx30m  -Xms30m -XX:+UseSerialGC  -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000
		//这种现象原因为: 虚拟机对于体积不大的对象  会优先把数据分配到TLAB区域中，因此就失去了在老年代分配的机会
		
		
		//参数: -Xmx30m  -Xms30m  -XX:+UseSerialGC  -XX:+PrintGCDetails  -XX:PretenureSizeThreshold=1000  -XX:-UseTLAB
		//这种就可以屏蔽TLAB，完成我们预期
		
		Map<Integer,byte[]> m = new HashMap<Integer, byte[]>();  
		for(int i=0; i<5*1024;i++){  //总计会放入5M
			byte [] b = new byte[1024];   //每次放1k
			m.put(i, b);
		}
		
		//在关闭TLAB之前，设置大于1K的对象直接放入老年代
		
	}

}
