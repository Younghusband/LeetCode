package com.problems.code.easy;
/************************************************
    * Description: 
    *   Given an array of integers, return indices of the two numbers such that they add up to a specific target.
        You may assume that each input would have exactly one solution.
    * 
    *  哈哈哈  我这属于 Brute Force . 比较慢
    * 
    * 
    * @author    杨帆  
    * @version  1.0
    * @date ：2017年1月12日 下午5:20:46 
**************************************************/
public class Two_Sum {
	
	public static void main(String[] args) {
		int [] arr = {2, 7, 11, 15};
		arr = twoSum666(arr,9);
		for( int i : arr)
		   System.out.print(i+"->");
		
	}
	
	public static int[] twoSum(int[] nums, int target) {
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
    		throw null;	
    	}
        int [] result = new int[] {a,b};
    	return result;
    }
	
	
	
	/**
	 * 速度超快这种
	 */
	public static int[] twoSum666(int[] nums, int target) {
        int[] map = new int[16030];
        for (int i = 0; i < nums.length; i++) {
           int diff=target-nums[i]+5;				//给了一个5的缓冲
           if (diff < 0) continue;				//不在范围内
           if(map[diff]>0){					//在map数组中
               return new int[] {map[diff]-1,i};
           }
           map[nums[i]+5]=i+1;					//放入map数组中
        }
        throw null;
}

}
