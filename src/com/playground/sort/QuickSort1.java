package com.playground.sort;

/**
 * @author: Vermouth
 * @create: 2020-07-08 10:18
 * @description: lueluelue
 **/

public class QuickSort1 {

    public static void main(String[] args) {
        QuickSort1 sort = new QuickSort1();
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        sort.recurseSort(arr, 0, arr.length - 1);
        sort.print(arr);
    }


    public void recurseSort(int [] arr, int lo, int hi) {
        if(lo < hi) {
            int partionIndex = partion(arr, lo, hi);
            recurseSort(arr, lo, partionIndex -1);
            recurseSort(arr, partionIndex + 1, hi);
        }
    }

    public int partion(int [] arr, int lo, int hi) {
        int key = arr[lo];
        while(lo < hi) {
            while(hi > lo && arr[hi] >= key) {
                hi --;
            }
            arr[lo] = arr[hi];
            while(hi > lo && arr[lo] <= key) {
                lo ++;
            }
            arr[hi] = arr[lo];
        }
        arr[hi] = key;
        return hi;
    }

    public static void print(int [] arr){
        System.out.println("\n>>>>>>>>>>>>>>>>>排序后的数组>>>>>>>>>>>>>>>>>");
        for(int i: arr)
            System.out.print(i+"->");
        System.out.print("\n");
    }
}
