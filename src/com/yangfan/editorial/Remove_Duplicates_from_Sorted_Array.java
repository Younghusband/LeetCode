package com.yangfan.editorial;
/************************************************
    * Description: 
    *    editorial solution 
    *    它的思路很简单  一个pointer用来遍历完整个数组  
    *    另一个pointer用来构造前半部分不含有重复数据的数组
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年2月23日 下午3:47:10 
**************************************************/
public class Remove_Duplicates_from_Sorted_Array {
     
	public static void main(String[] args) {
		int [] arr = {-3,-1,0,0,0,3,3};   //应该返回5
		  int lenBack = new Remove_Duplicates_from_Sorted_Array().removeDuplicates(arr);
		  System.out.println(lenBack);
		  for(int i=0;i<lenBack;i++){
			  System.out.print(arr[i]+" ");
		  }
	}
	
	public int removeDuplicates(int[] nums) {
	    if(nums.length<=1) return nums.length;
	    int i=0;
	    for(int j=1;j<nums.length;j++){
	    	if(nums[i]!=nums[j]){
	    		i++;
	    		nums[i]=nums[j];
	    	}
	    }
	    return i+1;
	}
}
