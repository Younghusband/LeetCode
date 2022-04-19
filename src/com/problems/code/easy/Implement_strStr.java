package com.problems.code.easy;
/************************************************
 * Description:
 *  28. Implement strStr().
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * this is a Brute-Force
 *
 * @author    Vermouth.yf
 * @version  1.0
 * @date ：2017年2月24日 上午10:58:25
**************************************************/
public class Implement_strStr {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		String haystack = "helloxxdfdf?world df3ddfsworld";
		String needle = "world";

		String h = "h";
		String n = "h";
	    int test1 = strStr(h, n);
//	    int test2 = strStr1(haystack, needle);
//	    System.out.println(haystack.indexOf(needle));
		System.out.println(test1);
	}

	/**
	 * 自己写出来的理解障碍最小
	 */
	public static int strPro(String haystack, String needle) {
		int left = 0;
		int right = needle.length();
		while(right <= haystack.length()) {
			if(needle.equals(haystack.substring(left, right))) {
				return left;
			} else {
				left++;
				right++;
			}
		}
		return -1;
	}
	
	/**
	 * just brute-force
	 */
	public static int strStr(String haystack, String needle) {
		for(int i = 0;;i++) {
			for(int j = 0;;j++) {
				if(j == needle.length()) return i; // 这一步和下面那步的顺序不能乱
				if(i + j == haystack.length()) return -1;
				if(needle.charAt(j) != haystack.charAt(i + j)) break;
			}
		}
    }
	
	/**
	 * another solution add some constraints in for-loop
	 * */
	public static int strStr1(String haystack, String needle) {
		for(int i = 0;i <= haystack.length() - needle.length();i++) {
			for(int j = 0; j < needle.length() && needle.charAt(j) == haystack.charAt(i + j); j++){
				if(j == needle.length() - 1) return i;
			}
		}
		return -1;
    }

}
