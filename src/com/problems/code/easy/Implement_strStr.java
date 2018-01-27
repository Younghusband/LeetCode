package com.problems.code.easy;
/************************************************
    * Description: 
    *  Implement strStr().

	   Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

	   Subscribe to see which companies asked this question.

    *  字面意思就不解释了。
    *  这个题目就是让你用自己的代码  实现 haystack.indexOf(needle) 这一个功能
    *  
    *  this is a Brute-Force
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年2月24日 上午10:58:25 
**************************************************/
public class Implement_strStr {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Implement_strStr e = new Implement_strStr();
		String haystack = "helloxxdfdf?world df3ddfsworld";
		String needle = "world";
	    int test1 = e.strStr(haystack, needle);	
	    int test2 = e.strStr1(haystack, needle);	
	    System.out.println(haystack.indexOf(needle));
	    System.out.println(test1==test2?true:false);
	}
	
	
	public int strStr(String haystack, String needle) {
		for(int i =0;;i++){
			for(int j=0;;j++){
				if(j==needle.length()) return i;   //如果不能保证needle在一个j的范围内全部通过第三条if 就不可能走到这一步
				if(i+j == haystack.length()) return -1;
				if(needle.charAt(j)!=haystack.charAt(i+j)) break;
			}
		}
    }
	
	/**
	 * another solution add some constraints in for-loop
	 * */
	public int strStr1(String haystack, String needle) {
		if(needle.length()==0) return 0;  //edge case
		for(int i=0;i<=haystack.length()-needle.length();i++){   //pretend stack is 8 needle is 7  need twice
			for(int j=0;j<needle.length()&&needle.charAt(j)==haystack.charAt(i+j);j++){
				if(j==needle.length()-1) return i;
			}
		}
		return -1;
    }
}
