package com.problems.code.easy;

import java.util.Arrays;

/************************************************
    * Description: 
    * 
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	Note:
	You may assume that nums1 has enough space (size that is greater or equal to m + n) 
	to hold additional elements from nums2. 
	The number of elements initialized in nums1 and nums2 are m and n respectively.
    * 
    * 
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年3月7日 下午3:18:07 
**************************************************/
public class Merge_Sorted_Array {
	
	 public static void main(String[] args) {
		int [] nums1 = {1,3,5,10,11,0,0,0,0};
		int [] nums2 = {2,4,5,6};
		merge(nums1,nums1.length,nums2,nums2.length);
		for(int temp : nums1)
			System.out.println(temp+"->");
	}
	
	  /**
	     * 首先理解问题的本质， 给定nums1.length = m + n
	     * m仅仅是nums1的有效位数  这样就理解了
	     * 
	     * 
	     */
	    public static void merge(int[] A, int m, int[] B, int n) {
//	          for(int i=0;i<n;i++)
//	        	  A[i+m]=B[i];
//	          Arrays.sort(A);
	    	int i=m-1, j=n-1, k=m+n-1;
	        while (i>-1 && j>-1) A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
	        while (j>-1)         A[k--]=B[j--];
	     }

}
