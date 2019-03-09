package com.playground.sort;
/**
 * @description 
 *   将两个有序数组进行合并  是 归并排序的众多操作的最后一步
 *   
 *   在这里我们先研究如何将两个有序数组合并为一个有序数组
 *  
 * @author vermouth.Mac
 * @version 2017年2月28日 下午10:21:08
 */

public class Merge2SortedArray {
	
	public static void main(String[] args) {
	    
	    Merge2SortedArray service = new Merge2SortedArray();
		
		int [] arr1 = {3,6,7,9,10,15};
		int [] arr2 = {1,4,8,11,12};
		
		for(int i : service.sortArr(arr1, arr2))
			System.out.print(i+"->");
	}

	
	
	
	
	/**
	 * 更简洁，少了一个临时变量
	 * */
	public int[] sortArrPro(int[] arr1, int[] arr2) {
		int[] array = new int[arr1.length + arr2.length];
		int i = 0, j = 0;
		while (i < arr1.length && j < arr2.length) {  //两个数组都完整的时候出不了这个循环
			array[i + j] = arr1[i] < arr1[j] ? arr1[i++] : arr2[j++];
		}
		while (i < arr1.length) {  //数组1还没耗尽
			array[i + j] = arr1[i++];
		}
		while (j < arr2.length) {  //数组2还没耗尽
			array[i + j] = arr2[j++];
		}
		return array;
	}
	
	
	
	/**
	 * my solution
	 * */
	public int [] sortArr(int[] arr1,int[] arr2) {
        if (null == arr1 || arr1.length == 0) return arr2;
        if (null == arr2 || arr2.length == 0) return arr1;
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, x = 0;
        while (i < arr1.length && j < arr2.length) { // 一旦数组1或者数组2元素用完，内部for循环将另一个数组全部装填进result
            if (arr1[i] < arr2[j]) {
                result[x++] = arr1[i++];
            } else {
                result[x++] = arr2[j++];
            }
        }
        while(i < arr1.length) {
            result[x++] = arr1[i++];
        }
        while(j < arr2.length) {
            result[x++] = arr2[j++];
        }
        return result;
	}
	
}
