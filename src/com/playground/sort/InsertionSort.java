package com.playground.sort;

/*********************************************
 * InsertionSort.java
 * Author: Vermouth.yf
 * Created on: 2017-8-16
 *
 * Details: 
 * 
 * 插入排序
 * 
 * 插入排序是在一个已经有序的小序列的基础上，一次插入一个元素。当然，刚开始这个有序的小序列只有1个元素，就是第一个元素。
 * 比较是从有序序列的末尾开始，也就是想要插入的元素和已经有序的最大者开始比起，如果比它大则直接插入在其后面，
 * 否则一直往前找直到找到它该插入的位置。如果碰见一个和插入元素相等的，那么插入元素把想插入的元素放在相等元素的后面。
 * 所以，相等元素的前后顺序没有改变，从原无序序列出去的顺序就是排好序后的顺序，所以插入排序是稳定的。
 * 
 * 1. 要么每次平移数组，然后最后交换元素
 * 2. 要么每次都交换元素
 * 
 * 哪种更合适？ 主流的似乎都是平移数组，最后交换元素
 * 
 ********************************************/

public class InsertionSort {
    
	public static void main(String[] args) {
	    InsertionSort sort = new InsertionSort();
		int [] arr = {6,3,4,2,1,7,9,8,5};
////		insertSort(arr);
		sort.sortArr(arr);
        BubbleSort.print(arr);
	}
	
	
    public void insertSort(int[] arr) {
        int location = 0;
        int target = 0;
        for (int i = 1; i < arr.length; i++) {
            location = i;
            target = arr[i]; //将标的存储起来
            for (int j = i - 1; j >= 0; j--) {
                if (target >= arr[j])
                    break;
                else { //如果 i位置的元素小于j位置的，记录i位置的元素该插入的位置location，同时将数组向后平移
                    arr[j + 1] = arr[j];
                    location = j;
                }
            } //内层循环确定了location的位置，然后外层循环将存储的值赋给location位置
            arr[location] = target; // location一定不等于i
        }
    }
	
	public void sortArr(int[] arr) {  //这个和上面的方法没有区别
        for(int i=1;i<arr.length;i++){
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
