package com.yangfan.sort;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2017年2月28日 下午9:12:44
 */

public class InsertionSort {
       public static void main(String[] args) {
		int [] arr = {8,3,4,1,6,7,9,1};
		sortArr(arr);
		for(int i : arr)
			System.out.print(i+"->");
	}
    
	private static void sortArr(int[] arr) {
		for(int i=1;i<4;i++){
			int j = i-1;
			int temp = arr[i];
			while(j>=0&&temp<arr[j]){ //如果arr[i] 大于等于某个前半部分的值 此次插入结束
					arr[j+1] = arr[j];
					j--;
			}
			arr[j+1]=temp;
		}
	}
}
