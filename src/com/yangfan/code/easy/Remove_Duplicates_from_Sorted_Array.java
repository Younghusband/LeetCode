package com.yangfan.code.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/************************************************
    * Description: 
    *  Given a sorted array, remove the duplicates in place such that 
    *  each element appear only once and return the new length.

       Do not allocate extra space for another array, you must do this in place with constant memory.
       
        For example,
        Given input array nums = [1,1,2],

		Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
		It doesn't matter what you leave beyond the new length. 
        
    * 
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年2月23日 下午2:12:48 
**************************************************/
public class Remove_Duplicates_from_Sorted_Array {
	
	 public static void main(String[] args) {
		  int [] arr = {-3,-1,0,0,0,3,3};   //应该返回5
		  int lenBack = removeDuplicates(arr);
		  System.out.println(lenBack);
		  for(int i=0;i<lenBack;i++){
			  System.out.print(arr[i]+" ");
		  }
	}
	
	 
	 /**
	  * 抛开思想 先说说感受
	  * for循环下面的语句如果只有一行  可以省略大括号 
	  * 但如果下面的第一行也是个if while 之类的同逻辑的东西
	  * 那么它们下面只有一行的话 也可以省略大括号..  有点像递归...
	  * 
	  * 执行if(i==0 || n>nums[i-1]) 时   当i==0时  没问题
	  * 执行if(i==0 | n>nums[i-1]) 时 当i==0时   报错！
	  * 
	  * */
     public static int removeDuplicates(int[] nums) {
    	int i = 0;
 	    for (int n : nums)
 	        if (i == 0 || n > nums[i-1])   
 	            nums[i++] = n;
 	    return i;
    }
     
     /**
      * 
      * */
     public static int removeDuplicates1(int [] nums){
    	 int i = nums.length > 0 ? 1 : 0;  //如果nums.length==0 增强for循环不会执行
    	    for (int n : nums)
    	        if (n > nums[i-1])
    	            nums[i++] = n;
    	    return i;
     }
     
     
     /**
      * 我这种方法很蠢  还单独开辟了一个TreeMap来存储数据
      * 
      * */
     public static int returnLen(int [] nums){
    	 if(nums.length<=1) return nums.length;
    	 Map<Integer,Integer> store = new TreeMap<Integer,Integer>();
    	 for(int i=0;i<nums.length;i++){   // only suitable for the case Sorted-array
    		 if(!store.containsKey(nums[i]))  {
    			 store.put(nums[i], 1);
    		 }else{
    		 store.put(nums[i], store.get(nums[i])+1);
    		 }
    	 }
    	 System.out.println(store);
    	 Iterator<Map.Entry<Integer,Integer>> it = store.entrySet().iterator();
    	 int index=0;
    	 while(it.hasNext()){
    		 Map.Entry<Integer, Integer> entry = it.next();
    		 nums[index++] = entry.getKey();
    	 }
    	 return store.size();
     }

}
