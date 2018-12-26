package com.problems;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月28日 下午6:46:46
 * 
 * 阿里巴巴AI LAB在线编程
 * 
 * //评测题目: 1.查找整数 
	输入：一个有序数组阵列，一个整数n 
	输出：如果n在阵列里，输出n的位置;如果n不在阵列中输出n可以插入的位置，插入后的数组仍然有序 
	例如： 
	[1,3,5,6]，5→2 
	[1,3,5,6]，2→1 
	[1,3,5,6]，7→4 
	[1,3,5,6]，0→0
	
	// 输入: 一维数组 输出: 目标元素的位置
 * 
 */

public class FindAndInsert {
	
     public static void main(String[] args) {
    	FindAndInsert f = new FindAndInsert(); 
    	 
	    int [] arr = {1,3,6,8};
	    int key1 = 1;
	    int key2 = 7;
			System.out.println(f.getLocation(arr,key2));
			System.out.println("杨帆");
	}
     
     public int getLocation(int [] arr, int key){
    	 int i;
    	 for(i=0;i<arr.length;i++){
    		 if(arr[i]>key){
    			 insertArr(arr,i,key);
    			 break;
    		 }else if(arr[i]==key)
    			 break;
    		 //如果arr[i]<key 一直成立，最后就return了arr.length作为下标了
    	 }
    	 return i;
     }
     
     public void insertArr(int [] arr, int location,int key){
    	 int [] arrP = new int[arr.length+1];
    	 for(int i=0;i<arrP.length;i++){
    		 if(i==location)
    			 arrP[i] = key;
    		 else if(i<location)
    			 arrP[i] = arr[i];
    		 else{
    			 arrP[i] = arr[i-1];
    		 }
    	 }
    	 //问题来了，如何将n+1长度的数组传给长度为n的定长数组
     }
     
}
