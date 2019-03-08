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
	    SelectionSort sort = new SelectionSort();
	    int [] arr= {9,3,2,1,5,6,8,7,4};
	    sort.selectionSort(arr);
	    BubbleSort.print(arr);
	}
	
    public void selectionSort(int[] arr) {
        int location = 0; // 尽量不要在for循环中初始化变量
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) { // 第一个位置~倒数第二个位置的选址  一共n-1轮
            location = i;
            for (int j = i + 1; j < arr.length; j++) { // 每一轮记录选择最小元素的地址
                if (arr[j] < arr[location]) { // 与记录的最小值进行比较，并视情况更新最小值的下标
                    location = j;
                }
            }
            if(location != i) {
                temp = arr[i];
                arr[i] = arr[location];
                arr[location] = temp;
            }
        }
    }
	
}
