package com.yangfan.sort;
/**
 * @description 
 *   将两个有序数组进行合并  是 归并排序的众多操作的最后一步
 *   
 *   在这里我们先研究如何将两个有序数组合并为一个有序数组
 *  
 * @author vermouth.Mac
 * @version 2017年2月28日 下午10:21:08
 */

public class MergeSort {
	
	public static void main(String[] args) {
		int [] arr1 = {3,6,7,9,10,15};
		int [] arr2 = {1,4,8,11,12};
		int [] result = sortArrPro(arr1,arr2);
		for(int i : result)
			System.out.print(i+"->");
	}

	
	/**
	 * 非常棒的代码  尤其是三元运算符那里
	 * */
	private static int [] sortArrPro(int [] arr1,int[] arr2){
		int [] array = new int [arr1.length+arr2.length];
		int i=0,j=0;
		while(i<arr1.length&&j<arr2.length){
			array[i+j]=arr1[i]<arr1[j]?arr1[i++]:arr2[j++];
		}
		while(i<arr1.length){
			array[i+j]=arr1[i++];
		}
		while(j<arr2.length){
			array[i+j]=arr2[j++];
		}
        return array;		
	}
	
	
	
	/**
	 * 我这样合并是不是太蠢了  
	 * */
	private static int [] sortArr(int[] arr1,int[] arr2) {
		if(arr1.length==0) return arr2;
		if(arr2.length==0) return arr1;
		int [] result =new int[arr1.length+arr2.length];
		int i=0,j=0,x=0;
		
		while(i<arr1.length&&j<arr2.length){
			if(arr1[i]<arr2[j]){
				result[x++]=arr1[i++];
			}else{
				result[x++]=arr2[j++];
			}
			if(i==arr1.length)
				for(int u=j;u<arr2.length;u++)
					result[x++]=arr2[u];
			
			if(j==arr2.length)
				for(int u=i;u<arr1.length;u++)
					result[x++]=arr1[u];
			
		}
		return result;
	}

}
