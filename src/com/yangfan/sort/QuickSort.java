package com.yangfan.sort;

import java.util.*;

/*********************************************
 * QuickSort.java
 * Author: Vermouth.yf
 * Created on: 2017-8-21
 *
 * Details:   快速排序
 *            不稳定，可能会改变相同大小元素的初始相对位置。
 *            
 ********************************************/

public class QuickSort {
	
	public static void main(String[] args) {
//		int [] arr = generateRandom(10,1,20);
//		int [] arr = {4,2,1,3,5,7,6};
		int [] arr = {6,1,2,7,9,3,4,5,10,8};
		
		System.out.println(partition(arr,0,arr.length-1));
		
		quickSort(arr);
		
//		print(arr);
	}
	
	
    private static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描 直到找到右侧小于基准数停止
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){//从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }	
        array[hi]=key;
        return hi;
        
    }
    
    private static void sort(int[] array,int lo ,int hi){
    	print(array);
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1); 
        sort(array,index+1,hi); 
    }
	
	
	public static void quickSort(int[] arr) {
		sort(arr,0,arr.length-1);  //调用方式类似 Arrays.sort
	}


	/**
	 * Author: Vermouth.yf 
	 * Date: 2017-8-21 
	 * @param nums   数组大小
	 * @param min    数组最小值
	 * @param max    数组最大值
	 * @return
	 */
	public static int[] generateRandom(int nums, int min, int max){
		int [] arr = new int[nums];  //初始化如此之大的数组
		Random ran = new Random();
		for(int i=0;arr[arr.length-1]==0;i++){
			int temp = ran.nextInt(max);
			boolean flag = false;
			if(temp>=min&&temp<=max){
				flag=!flag;   //为了降低无用操作
			}
			if(flag){  //校验元素是否在数组中已经存在,如果存在 继续下一次循环
				checkAndAdd(arr,temp);
			}
		}
		System.out.println("生成的随机数数组:");
		for(int i: arr)
		   System.out.print(i+"->");
		return arr;
	}
	
	
	/**
	 * 检查数组中是否已有该target, 有则不作任何操作，无则加到数组末尾
	 * 从头遍历到尾,遇到0就赋值并break. 遇到等于target的值直接break
	 * @param arr
	 * @param target
	 */
	public static void checkAndAdd(int [] arr,int target){
		int index = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==0){
				arr[i]=target;
				index = i;
				System.out.println("在第"+(index+1)+"个位置上插入了随机数。");
				break;
			}
			if(arr[i]==target){
				break;
			}
		}
	}
	
	public static void print(int [] arr){
		System.out.println("\n>>>>>>>>>>>>>>>>>排序后的数组>>>>>>>>>>>>>>>>>");
		for(int i: arr)
			   System.out.print(i+"->");	
        System.out.print("\n");
	}

}
