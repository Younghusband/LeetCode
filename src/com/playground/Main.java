package com.playground;

import java.util.Map;


/**
 * @author mr_yo
 * playground
 */
public class Main {

    private Map map;
    

    public static void main(String[] args) {
        Main sort = new Main();
//        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        int[] arr = { 9, 1, 5, 3, 4, 2, 6, 8, 7};
//      int[] arr = {1, 2, 3, 4, 5, 6, 7};
//      sort.sort(arr, 0, arr.length-1);
//        sort.sort(arr);
//        sort.print(arr);

//        System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");     //系统的最大空间
//        System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");   //系统的空闲空间
//        System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");   //当前可用的总空间

        byte [] bArr = null;
//        for(int i = 0; i< 10; i++)
//            b = new byte[1*1024*1024];


    }



    public static void print(int [] arr) {
        System.out.println("\n>>>>>>>>>>>>>>>>>排序后的数组>>>>>>>>>>>>>>>>>");
        for(int i: arr)
            System.out.print(i+"->");
        System.out.print("\n");
    }



}
