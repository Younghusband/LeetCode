package com.problems.code.easy;
/************************************************
 * Description: Write a function to find the longest common prefix string
 * amongst an array of strings.
 * 
 * @author Vermouth.yf
 * @version 1.0
 * @date ：2017年1月20日 下午4:05:04
 **************************************************/
public class Longest_Common_Prefix {
	
	public static void main(String[] args) {
		String [] strs = {"abc","abdddc","abcd","abcfdfasdfbc"};
		String [] cornerCase = {"","a"};
		System.out.println(new Longest_Common_Prefix().longestCommonPrefix(strs));
	}
	
	public String longestCommonPrefix(String[] strs) {
		if(strs==null||strs.length==0) return "";
		int len = this.getMinLen(strs);  // this.  2333
        int j=0;
        out: while(j<len){
        	   int i = 1;
	        	while(i<strs.length){
	        		if(strs[0].charAt(j)==strs[i++].charAt(j)){}
	        		else
	        			break out;  //end the outer loop , flag or sth is not necessary
	        	}
	        	j++;
            }
		return strs[0].substring(0, j);
	}
	public int getMinLen(String[] strs){
		int temp = Integer.MAX_VALUE;
		for(int i=0;i<strs.length;i++){
			temp=(temp>strs[i].length())?strs[i].length():temp;
		}
		return temp;
	}
}
