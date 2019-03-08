package com.playground.sort;

import java.util.Random;

/**
 * @author mr_yo
 * 
 * Invented by Donald Shell
 */
public class ShellSort {
    
    public static void main(String[] args) {
        ShellSort shell = new ShellSort();
        int [] arr= {9,3,2,1,5,6,8,7,4};
        shell.ShellSort(arr);
        for(int item : arr) {
            System.out.print(item+"->");
        }
        
        Random ran = new Random();
        ran.nextInt(500);
        
    }
    
    
    
    /**
     * @param arr
     * @return
     */
    public int[] ShellSort(int[] arr) {
        int len = arr.length;
        int temp, gap = len / 2;
        while(gap > 0) {
            for (int i=gap; i< len; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return arr;
    }
    

}
