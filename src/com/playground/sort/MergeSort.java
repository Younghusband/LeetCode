package com.playground.sort;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月24日 下午9:03:54
 * 
 * 
 * 归并排序
 * 
 * 讲起来比较复杂，就写在博客里了。
 * 
 * 
 * 
 */

public class MergeSort {
	
	public static void main(String[] args) {
		
//		  int[] array = {
//	                9, 1, 5, 3, 4, 2, 6, 8, 7
//	        };
	      
	      int[] array = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
		  
		  MergeSort x = new MergeSort();
		  System.out.print("排序前:\t");
		  x.print(array);
		  x.mergeSort(array);
		  System.out.print("排序后:\t");
		  x.print(array);
		  
	}
	
	
	
	//总方法
	public void mergeSort(int[] arr){
		for (int gap = 1; gap < arr.length; gap = gap * 2) {  //粒度从1开始合并
			mergeArrays(arr, gap, arr.length);
			System.out.print("gap=" + gap + ":\t");
			print(arr);
		}
	}


	//不断的合并所有子数组的方法
	public void mergeArrays(int [] arr,int gap,int length){
		int i = 0;   //整个方法共享
		for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap) {
			merge(arr, i, i + gap - 1, i + 2 * gap - 1);   //把相邻两段长度均为gap的排序好的数组合并
		}

		//如果剩下一个数组不够gap
		if (i + gap - 1 < length) {
			merge(arr, i, i + gap - 1, length - 1);
		}

	}
	
	//将lo~mid  mid+1~hi 这两段排序 然后重新赋值进arr
	public void merge(int [] arr, int lo, int mid, int hi){
		int i = lo;       //第一段数组下标
		int j = mid + 1;    //第二段数组下标
		int k = 0;        //临时数组下标
		int[] arrayTemp = new int[hi - lo + 1];  //临时数组的长度

		while (i <= mid && j <= hi) {
			if (arr[i] <= arr[j]) {
				arrayTemp[k++] = arr[i++];
			} else {
				arrayTemp[k++] = arr[j++];
			}
		}
		//下面两个while只有可能进入一个
		while (i <= mid) {  //后半段用完的情况
			arrayTemp[k++] = arr[i++];
		}
		while (j <= hi) {   //前半段用完的情况
			arrayTemp[k++] = arr[j++];
		}
		//!!!!! 最后要把这个临时数组的值复制到数组中
		for (int x = 0; x < arrayTemp.length; x++) {
			arr[lo++] = arrayTemp[x];
		}
	}
	
	
	public  void print(int[] list){
		for(int i: list){
			System.out.print(i+"\t");
		}
		System.out.println();
	}
	

}
