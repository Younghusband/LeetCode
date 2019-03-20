package com.problems.code.easy;
/**
 * @description 
 *Given a sorted array and a target value, return the index if the target is found. If not, 
 *return the index where it would be if it were inserted in order.

   You may assume no duplicates in the array.

   Here are few examples.
 * 
 *          [1,3,5,6], 5 → 2
            [1,3,5,6], 2 → 1
            [1,3,5,6], 7 → 4
            [1,3,5,6], 0 → 0
 * 
 * 
 * @author vermouth.Mac
 * @version 2017年2月24日 下午10:40:39
 * 
 * 他妈的阿里考过这个弱智题目
 */

public class Search_Insert_Position {
	
	public static void main(String[] args) {
		Search_Insert_Position p = new Search_Insert_Position();
		int [] arr = {1,3,4,5,7,8};
		System.out.println(p.searchInsert(arr,9));
		
		int [] arr1 = {};
		System.out.println(p.searchInsert(arr1,0));
		
	}
	
	
	   public int searchInsert(int[] nums, int target) {
	      for(int i=0;i<nums.length;i++)
	    	  if(nums[i]>=target) return i;
	      return nums.length;
	    }
}
