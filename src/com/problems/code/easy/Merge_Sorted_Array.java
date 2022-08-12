package com.problems.code.easy;

import com.util.StringUtil;

import java.util.Arrays;

/************************************************
 * Description:
 * 88. Merge Sorted Array
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n)
 * to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 * @author    Vermouth.yf
 * @version  1.0
 * @date ：2017年3月7日 下午3:18:07
**************************************************/
public class Merge_Sorted_Array {
	
	public static void main(String[] args) {
		int [] nums1 = {1,3,5,10,11,0,0,0,0};
		int [] nums2 = {2,4,5,6};
		merge1(nums1, 5, nums2, nums2.length);
		StringUtil.printDigitArray("->", nums1);
	}
	
	/**
	 * 首先理解问题的本质， 给定nums1.length = m + n
	 * m仅仅是nums1的有效位数  这样就理解了
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
//	        for(int i=0;i<n;i++)
//	        	  nums1[i+m]=nums2[i];
//	        Arrays.sort(nums1);
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i > -1 && j > -1) nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
		while (j > -1) nums1[k--] = nums2[j--];
	}

	public static void merge1(int[] nums1, int m, int[] nums2, int n) {
		System.arraycopy(nums2,0,nums1,m,n);
		Arrays.sort(nums1);
	}


}
