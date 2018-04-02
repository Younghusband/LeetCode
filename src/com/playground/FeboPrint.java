package com.playground;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月26日 下午2:30:49
 * 
 * 面试的时候，手写遍历肥波纳妾数列
 * 
 * 
 */

public class FeboPrint {

	
	public static void main(String[] args) {
//		for(int i=0;i<=6;i++)
//			System.out.print(getFeb(i)+"->");
		printFeb(6);
	}
	
	public static void printFeb(int n){
		int a1 = 1;
		int a2 = 1;
		for(int i=0;i<=n;i++){
			if(i==0||i==1){
				System.out.println(1);
			}else{
				int temp = a1+a2;
				System.out.println(temp);
				a1 = a2;
				a2 = temp;
			}
		}
	}
	
	
	
	
	
}
