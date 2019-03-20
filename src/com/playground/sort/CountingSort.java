package com.playground.sort;

/**
 * @author mr_yo
 * 
 * 计数排序，很有意思。 自己实现一下
 * 
 */
public class CountingSort {
    
    public static void main(String[] args) {
        CountingSort sort = new CountingSort();
        int [] arr = sort.arrGenerator(66, 1000);
        
        sort.countingSort(arr);
        
        for(int i : arr) {
            System.out.print(i+"->");
        }
        
    }
    
    
    public void countingSort(int [] arr) {
        
        
        
    }
    
    /**
     * @param range  范围默认从0开始到range值
     * @param nums   一共多少个数
     * @return
     */
    public int[] arrGenerator(int range, int nums) {
        int [] result = new int[nums];
        
        return result;
    }
    

}
