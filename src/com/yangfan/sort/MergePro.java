package com.yangfan.sort;

import java.util.Arrays;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月25日 下午5:56:28
 * 
 * 
 * 用递归来实现归并
 */

public class MergePro {
	
	
	public static void main(String[] args) {
		MergePro  user = new MergePro();
		
		int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
		user.mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
		
	}
	
	public  void mergeSort(int[] a, int low, int high) {
		MergeSort tool = new MergeSort();
        int mid = low+(high-low)/2;   //试问为什么不用 mid = (low+high)/2
        if (low < high) {
            // 左边
            mergeSort(a, low, mid);
            // 右边
            mergeSort(a, mid + 1, high);
            // 左右归并
            tool.merge(a, low, mid, high);
            System.out.println(Arrays.toString(a));
        }

    }
	
	

}
