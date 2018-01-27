package com.problems.test;
/**
 * @description   
 *      测试String的各种 API
 *      这些方法不会改变原String的值
 *      只会按照各个方法的规则生成新的String
 *  
 * @author vermouth.Mac
 * @version 2017年3月8日 下午9:43:20
 */

public class TestStringAPI {
     public static void main(String[] args) {
		String str = " 123456ABC";
		String str1 = str.replace('1', '0');
		System.out.println(str1);
		System.out.println(str.endsWith("C"));
		
		String str2 =str.trim();
		System.out.println(str2);
		
		String str3 = str.toLowerCase();
		System.out.println(str3);
				
		System.out.println(str);
	}
}
