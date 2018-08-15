package com.playground.sort;

/*********************************************
 * SelectionSort.java
 * Author: Vermouth.yf
 * Created on: 2017-8-16
 *
 * Details:
 * 
 * 选择排序   
 * 
 * 在一趟选择，如果当前元素比一个元素小，而该小的元素又出现在一个和当前元素相等的元素后面，那么 交换后稳定性就被破坏了。
 * 比较拗口，举个例子，序列5 8 5 2 9， 我们知道第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了，
 * 所以选择排序不是一个稳定的排序算法。
 * 
 * 
 * 每轮记录下标， 将每轮的第一个元素和下标元素进行交换，然后进行下一轮
 * 
 ********************************************/

public class SelectionSort {  
	
	public static void main(String[] args) {
			int [] arr= {4,3,2,1,5,6,8,7};
		    selectionSort(arr);
		    BubbleSort.print(arr);
	}
	
	public static void selectionSort(int [] arr){
		int location = 0;
		int temp = 0;
		for(int i=0;i<arr.length-1;i++){
			location = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[location]){
					location = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[location];
			arr[location] = temp;
		}
	}
	

}
