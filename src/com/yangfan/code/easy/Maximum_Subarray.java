package com.yangfan.code.easy;

import java.util.Hashtable;

/************************************************
    * Description: 
    * 
    *  Find the contiguous subarray within an array (containing at least one number) 
    *  which has the largest sum.
       For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
       the contiguous subarray [4,-1,2,1] has the largest sum = 6. 
    * 
    *  一 是这个题目的思想很不错
    *  二 是借此机会 以后多用Math.max(arg1,arg2)来比较两个元素
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年2月28日 上午10:16:41 
**************************************************/
public class Maximum_Subarray {
	
	public static void main(String[] args) {
		int [] arr = {};
		int maxInt = maxSubArray(arr);
		System.out.println(maxInt);
	}
    
	
    /**
     * 从左至右  一个用来探索  一个用来保存进度
     * 
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int maxSofar = nums[0]; int maxEndingHere = nums[0];
    	for(int i=1;i<nums.length;i++){
    		maxEndingHere = Math.max(maxEndingHere+nums[i], nums[i]);
    		maxSofar = Math.max(maxSofar, maxEndingHere);
    	}
    	return maxSofar;
    }
	
}
