package com.playground;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author mr_yo
 * playground
 */
public class Main {

    
    private LinkedHashSet<String> localQueue; 
    
    private Map map;
    

    public static void main(String[] args) {
        Main sort = new Main();
//        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        
        int[] arr = { 9, 1, 5, 3, 4, 2, 6, 8, 7};
        
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        
//        sort.sort(arr, 0, arr.length-1);
//        print(arr);
        
//        System.out.println(sort.localQueue.size());
        System.out.println(null != sort.localQueue);
//        System.out.println("--------");
        Iterator it  = sort.map.entrySet().iterator();
        
        while(it.hasNext()) {
            
        }
        
    }
    
    
    
   
    

    
    public static void print(int [] arr){
        System.out.println("\n>>>>>>>>>>>>>>>>>排序后的数组>>>>>>>>>>>>>>>>>");
        for(int i: arr)
            System.out.print(i+"->");
        System.out.print("\n");
    }

}
