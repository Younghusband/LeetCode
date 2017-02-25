package com.yangfan.code;
/**
 * @description 
 *      The count-and-say sequence is the sequence of integers beginning as follows:
        1, 11, 21, 1211, 111221, ...

        1 is read off as "one 1" or 11.
        11 is read off as "two 1s" or 21.
        21 is read off as "one 2, then one 1" or 1211.
        Given an integer n, generate the nth sequence.
        Note: The sequence of integers will be represented as a string.
 * 
 * 
 * @author vermouth.Mac
 * @version 2017年2月25日 下午6:25:53
 */

public class Count_and_Say {
     public static void main(String[] args) {
		Count_and_Say c = new Count_and_Say();
		String s =c.countAndSay(3);   // 1,11,21
		System.out.println(s);
	}
     
     
     /**
      * 
     * @param n
     * @return
     */
    public String countAndSay(int n) {
    	if(n==1) return String.valueOf(1); 
    	
    	
    	
    	 return "";
     }
}
