package com.playground.sort;

import com.util.StringUtil;

/*********************************************
 * BubbleSort.java
 * Author: Vermouth.yf
 * Created on: 2017-8-16
 *
 * Details:
 * 冒泡排序   
 * 
 * 首先思路要清晰，这里有两个维度
 * 1. 冒泡次数
 * 2. 每轮比较次数
 *
 * tips:
 * 1. 每次相邻元素进行大小比较，谁大(小)往后冒
 * 2. 每轮冒泡结束，数组中最大的元素都会排列到数组的最末，并在下一次冒泡忽视它
 * 3. 如果某一轮未发生任何相邻元素交换，直接终止整个排序(即排序已完成)
 *
 * 重点是: 内层循环为每论冒泡的比较次数，外层循环为冒泡轮数
 * 
 * n为已经排序好的末端元素个数
 * 数组长度为			len
 * 冒泡次数为 			len-1
 * 每次冒泡的比较次数为	len-1-n   
 * 
 ********************************************/

public class BubbleSort {
	
	public static void main(String[] args) {
//		int [] arr = {4,3,2,1,5,6,8,7};
        int [] arr = {3,4,1,2,5,8,7,6};

        BubbleSort.bubble(arr);
        StringUtil.printDigitArray(", ", arr);
	}
	
    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean hasSwitch = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) { //由于j和j+1不相等，这是两个元素 所以放心大胆使用异或交换
                    hasSwitch = true;
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
            if (!hasSwitch)
                break;  // 某轮冒泡没有元素交换，终止冒泡排序流程
        }
    }

}
