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

        sort.quickSort(arr);

        print(arr);
    }


    public int partion(int [] arr, int lo, int hi) {
        return 0;
    }

    public void sort(int [] arr, int lo, int hi) {

    }

    public void quickSort(int [] arr){

    }





    public static void print(int [] arr){
        System.out.println("\n>>>>>>>>>>>>>>>>>排序后的数组>>>>>>>>>>>>>>>>>");
        for(int i: arr)
            System.out.print(i+"->");
        System.out.print("\n");
    }

}
