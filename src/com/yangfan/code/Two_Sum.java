package com.yangfan.code;
/************************************************
    * Description: 
    *   Given an array of integers, return indices of the two numbers such that they add up to a specific target.
        You may assume that each input would have exactly one solution.
    * 
    *  哈哈哈  我这属于 Brute Force 
    * 
    * 
    * @author    杨帆  
    * @version  1.0
    * @date ：2017年1月12日 下午5:20:46 
**************************************************/
public class Two_Sum {
	
	public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
    	int a=0,b=0;   //待加的
    	boolean flag = false;
    	
    	for(int i=0;i<len-1;i++){
    		for(int j=i+1;j<len;j++){
    			if((nums[i]+nums[j])==target){
    				a = i;
    				b = j;
    				flag = true;
    			}
    		}
    	}
    	if(!flag){
    		throw new RuntimeException("not found matching Pair");
    	}
        int [] result = new int[] {a,b};
    	return result;
    }

}
