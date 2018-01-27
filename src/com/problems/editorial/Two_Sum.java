package com.problems.editorial;

import java.util.HashMap;
import java.util.Map;

/************************************************
      Editorial Solution
         Approach #1 (Brute Force)
    *    Approach #2 (Two-pass Hash Table)
    *    Approach #3 (One-pass Hash Table)
    *     
    * 
    * @author    杨帆  
    * @version  1.0
    * @date ：2017年1月17日 上午11:16:53 
**************************************************/
public class Two_Sum {
	
	
	/**
	 * The brute force approach is simple. 
	 * Loop through each element x and find if there is another value that equals to target−x.
	 * "this Brute Force much better than mine" - YF
	 */
	public int[] twoSum1(int[] nums, int target) {
	    for(int i=0;i<nums.length-1;i++){
	    	for(int j=i+1;j<nums.length;j++){
	    		if(nums[i]==target - nums[j]){
	    			return new int[]{i,j};
	    		}
	    	}
	    }
		throw new IllegalArgumentException("No two sum solution");
	}
	
	
	
	/**
	 * two-pass hashtable -- two Iterations
	 */
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			map.put(nums[i], i);
		}
		for(int i=0;i<nums.length;i++){
			int complement = target - nums[i];
			if(map.containsKey(complement)&&map.get(complement)!=i){
				return new int[]{i,map.get(complement)};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	
	
	/**
	 * one-pass hashtable 
	 * 
	 * 这个one-pass hashtable 小代码有大智慧
	 */
	public int[] twoSum3(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			int complement = target - nums[i];
			if(map.containsKey(complement)){
				return new int[]{map.get(complement),i};
			}
		    map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

}
