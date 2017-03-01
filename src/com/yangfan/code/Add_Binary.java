package com.yangfan.code;
/************************************************
    * Description: 
    * 
    *  Given two binary strings, return their sum (also a binary string).
		For example,
		a = "11"
		b = "1"
		Return "100". 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年3月1日 下午1:13:40 
**************************************************/
public class Add_Binary {
      public static void main(String[] args) {
    	  String s1 = "101";
    	  String s2 = "10";   //结果是1+2+4=7  111
    	  System.out.println(addBinary(s1,s2));
	}
      
      
    /**
     *  算算数值  然后转为2进制返回是比较蠢的  
     *  对齐 然后直接逻辑运算返回字符串是聪明的
     */
    public static String addBinary(String a, String b) {
    	
    	return null;
      }
}
