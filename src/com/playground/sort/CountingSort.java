package com.playground.sort;

import java.util.Random;

/**
 * @author mr_yo
 * 
 * 计数排序，很有意思。 自己实现一下
 * 
 * 原数组 A
 * 计数数组 C
 * 返回的有序数组 R
 * 
 * 计数排序过程:
 * 1. 遍历原数组A, 生成计数数组C(初步)
 * 2. 将计数数组C从最低位累加至最高位, 生成位置数组C(最终)
 * 3. 从后向前(重点)遍历原数组A, 
 *    并将每一个遍历出来的值item作为C的下标取值为rank,
 *    然后将R中index = rank-1的位置放入item,
 *    该C[item]--作为新的rank
 * 
 * 2个核心点:
 * 1. 为什么计数数组C后面还要来一次递进的累加， 直接用各个位置计数的值来遍历输出至Result数组不就ok了吗
 * 2. 为什么原数组要倒序来取
 * 
 */
public class CountingSort {
    
    public static void main(String[] args) {
        CountingSort sort = new CountingSort();
        int range = 66; // 元素的范围 默认从0开始
        int nums = 1000; // 元素的数量
        int [] arr = sort.countingSort(range, sort.arrGenerator(range, nums));
        sort.print(40, arr);
    }
    
    public int [] countingSort(int range, int [] arr) {
        int [] C = new int [range+1];  // 对于计数排序，必须先知道待排序的众多元素的值的范围
        int [] R = new int [arr.length];  // result数组
        // init counting array
        for(int i=0; i<arr.length; i++) {
            C[arr[i]]++;    
        }
        // process counting array
        int sum = 0;
        for(int i=0; i<C.length; i++) {
            sum += C[i];
            C[i] = sum;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int item = arr[i];
            R[C[item]-1] = item;  // C数组中取出来的位置要减一  比如C中1代表着排在第一位，那么放入R肯定是R[0]
            C[item]--; // 拿出元素后计数减一
        }
        return R; // 当然你也可以把数组R的值拷贝至原数组A
    }
    
    /**
     * @param range  范围默认从0开始到range值
     * @param nums   一共多少个数
     * @return
     */
    public int[] arrGenerator(int range, int nums) {
        int [] result = new int[nums];
        Random r = new Random();
        for(int i=0; i<nums; i++) {
            result[i] = r.nextInt(range+1);
        }
        return result;
    }
    
    
    /**
     * @param columns 
     * @param arr
     */
    public void print(int columns, int [] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print("|"+arr[i]+"\t");
            if((i+1)%columns == 0) {
                 System.out.print("|");
                 System.out.println();
            }
        }
    }

}
