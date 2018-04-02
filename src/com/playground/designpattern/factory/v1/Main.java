package com.playground.designpattern.factory.v1;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月23日 上午12:00:14
 */

public class Main {
     
	public static void main(String[] args) {
		Shehui god = new Shehui();   //隐藏god
		People p1 = god.zaoRen("worker");
		People p2 = god.zaoRen("programmer");
		
		p1.produce();
		p2.produce();
		
	}
	
}
