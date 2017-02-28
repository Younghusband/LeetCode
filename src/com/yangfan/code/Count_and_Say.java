package com.yangfan.code;


/**
 * @description 
 *      The count-and-say sequence is the sequence of integers beginning as follows:
        1, 11, 21, 1211, 111221, 312211,13112221，

        1 is read off as "one 1" or 11.
        11 is read off as "two 1s" or 21.
        21 is read off as "one 2, then one 1" or 1211.
        Given an integer n, generate the nth sequence.
        Note: The sequence of integers will be represented as a string.
        
                        如果没理解错的话  输入3
        1，11，21    是返回21  而不是返回"1,11,21"
 * 
 * 
 * @author vermouth.Mac
 * @version 2017年2月25日 下午6:25:53
 */

public class Count_and_Say {
     public static void main(String[] args) {
		Count_and_Say c = new Count_and_Say();
		String s =c.countAndSay(5);   // 1,11,21
		System.out.println(s);
	}
     
     /**
      * 各项必然为偶数位的数字
      * 
      * n-1位记录的是n位数字 在前面出现的次数
      * 
      * 符合
      * 
     * @param n
     * @return
     */
    public String countAndSay(int n) {
    	if(n==1) return "1"; 
    	String temp = countAndSay(n-1);  //拿到前一项的值
    	StringBuffer sb = new StringBuffer();
    	int count = 1;
    	if(temp.length()==1) return sb.append(count).append(temp).toString();
    	for(int i=1;i<temp.length();i++){
    		if(temp.charAt(i)==temp.charAt(i-1)){
    			count++;
    			if(i==temp.length()-1){
    				sb.append(count).append(temp.charAt(i-1)); 
    			}
    		}else {
    			sb.append(count).append(temp.charAt(i-1));  
    			count = 1;  //遇到新的值  将count归1
    			if(i==temp.length()-1){
    				sb.append(count).append(temp.charAt(i));
    			}
    		}
    	}
    	 return sb.toString();
     }
}
