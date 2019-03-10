package com.playground;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mr_yo
 * playground
 */
public class Main {


    public static void main(String[] args) {
        Main sort = new Main();
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        sort.selectSort(arr);
        print(arr);
    }


    public void selectSort(int [] arr) {
        int location;
        for(int i=0; i<arr.length; i++) {
            location = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[location]) {
                    location = j;
                }
            }
            // swap
            if(location != i) {
                arr[i] = arr[i] + arr[location];
                arr[location] = arr[i] - arr[location];
                arr[i] = arr[i] - arr[location];
            }
        }
    }





    public static void print(int [] arr){
        System.out.println("\n>>>>>>>>>>>>>>>>>排序后的数组>>>>>>>>>>>>>>>>>");
        for(int i: arr)
            System.out.print(i+"->");
        System.out.print("\n");
    }

}
