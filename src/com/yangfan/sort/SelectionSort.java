package com.yangfan.sort;

/*********************************************
 * SelectionSort.java
 * Author: Vermouth.yf
 * Created on: 2017-8-16
 *
 * Details:
 * 
 * 选择排序   
 * 
 * 每轮记录下标， 将每轮的第一个元素和下标元素进行交换，然后进行下一轮
 * 
 * 我这样性能测试是很愚蠢的，得到的结论也不一定对
 ********************************************/

public class SelectionSort {  
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			int [] arr= {4,3,2,1,5,6,8,7};
		    selectionSort(arr);
//		    selectionPro(arr);
		}
		long end = System.currentTimeMillis();
//		BubbleSort.print(arr);
		System.out.println(end-start);
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
	
	//我这种改良其实已经不属于选择排序了，选择排序是不稳定的，我这种是稳定排序
	public static void selectionPro(int [] arr){
		int location = 0;
		int temp = 0;
		for(int i=0;i<arr.length-1;i++){
			location = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[location]){
					location = j;
				}
			}
			if(arr[i]!=arr[location]) {  //优于 i!=location
			    temp = arr[i];
			    arr[i] = arr[location];
			    arr[location] = temp;
			}
		}
	}
	

}
