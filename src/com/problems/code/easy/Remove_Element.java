package com.problems.code.easy;
/************************************************
    * Description: 
    * 
    * Given an array and a value, remove all instances of that value in place and return the new length.

      Do not allocate extra space for another array, you must do this in place with constant memory.

	  The order of elements can be changed. It doesn't matter what you leave beyond the new length.

	  Example:
		Given input array nums = [3,2,2,3], val = 3

		Your function should return length = 2, with the first two elements of nums being 2.
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年2月24日 上午10:32:13 
**************************************************/
public class Remove_Element {
     public static void main(String[] args) {
		Remove_Element e = new Remove_Element();
		int val = 0;
		int [] arr = {-3,-1,0,0,0,3,3};   //应该返回4 {-3,-1,3,3}
		int n = e.removeElement1(arr, val);
		System.out.println(n);
		for(int i : arr)
			System.out.print(i+"->");
	}
     
     
     /**
      * 跟上一题没啥区别嘛... 
      *
      */
    public int removeElement(int[] nums, int val) {
    	 int i = 0;  //数组为空 返回0 并不对数组进行操作
         for(int n : nums)
        	 if(n!=val)
        		 nums[i++]=n;
    	 return i;
     }
    
    
    /**
     * 尝试two pointers 
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums,int val){ 
    	int i=0;
    	for(int j=0;j<nums.length;j++){  //i==0 skip
    		if(nums[j]!=val)
    			nums[i++]=nums[j];
    	}
    	return i;
    }
}
