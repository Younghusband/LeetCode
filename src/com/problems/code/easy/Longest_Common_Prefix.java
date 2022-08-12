package com.problems.code.easy;
/************************************************
 * Description:
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string
 * amongst an array of strings.
 *
 * Example:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * 
 * @author Vermouth.yf
 * @version 1.0
 * @date ：2017年1月20日 下午4:05:04
 *
 * updated:
 * 这题可以等将来知识更加丰富之后回过来用新的知识刷
 *
 **************************************************/
public class Longest_Common_Prefix {
	
	public static void main(String[] args) {
//		String [] strs = {"abc","abdddc","abcd","abcfdfasdfbc"};
		String [] strs = {"","a"};
		System.out.println(new Longest_Common_Prefix().longestCommonPrefix(strs));

	}

//	public String longestCommonPrefix(String [] strs) {
//		String result = "";
//		if(strs == null || strs.length == 0) {
//			return result;
//		}
//		char currentChar = ' ';
//		for(int i = 0;; i++) {
//			String firstStr = strs[0];
//			result = firstStr.substring(0, i);
//			if(firstStr.length() < i+1) {
//				return result;
//			}
//			currentChar = firstStr.charAt(i);
//			for(int j=0; j < strs.length; j++) {
//				String currentStr = strs[j];
//				if(currentStr.length() < i+1) {
//					return result;
//				}
//				if(currentStr.charAt(i) != currentChar) {
//					return result;
//				}
//			}
//		}
//	}

	/**
	 * 先求出最大可能长度
	 */
	public String longestCommonPrefix(String [] strs) {
		if(strs == null || strs.length == 0) return "";
		int len = this.getMinLen(strs);  // this.  2333
        int charLoc = 0;
        out: while(charLoc < len) {
        		// 从第二个开始
        	   int strIndex = 1;
        	   while(strIndex < strs.length) {
				   if(strs[0].charAt(charLoc) != strs[strIndex++].charAt(charLoc))
				   	   break out;
        	   }
        	   charLoc++;
            }
		return strs[0].substring(0, charLoc);
	}

	private int getMinLen(String [] strs){
		int temp = Integer.MAX_VALUE;
		for(int i = 0; i < strs.length; i++) {
			temp=(temp > strs[i].length()) ? strs[i].length() : temp;
		}
		return temp;
	}
}
