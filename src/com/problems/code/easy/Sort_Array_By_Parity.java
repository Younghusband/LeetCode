package com.problems.code.easy;

/**
 * @author mr_yo
 * 
 * 从中的收获:
 * 
 * 1. 边缘条件的判断是比较low逼的，如果算法逻辑中能自动过滤掉边缘条件是极好的
 * 2. 有的时候需要牺牲空间换时间，但如果能直接在input上操作(不新建空间)的话那是极好的。
 * 
 * 针对此题, for( .. : xxx) forEach方式遍历数组效率比下标的方式要低很多。。
 */
public class Sort_Array_By_Parity {
    
    
    /**
     *  forEach方式的数组遍历效率  远低于  用下标的方式
     *  只是改变一下遍历方式，效率就有质一般的提升
     */
    public int[] sortArrayByParity(int[] A) {
        if(null == A || A.length == 0) return A;
        int [] resultArr = new int[A.length];
        int head = 0;
        int tail = A.length-1;
        for(int i=0; i<A.length; i++) {
            int item = A[i];
            if(item%2 == 0) {
                resultArr[head++] = item;
            } else {
                resultArr[tail--] = item;
            }
        }
        return resultArr;
    }
    
    
    
    
    /**
     * one-pass
     * no extra space
     * 
     * 
     */
    public int[] bestSolution(int[] A) {
        int even = 0, odd = A.length - 1;
        while (even < odd) {
            if (A[even] % 2 != 0) {
                int t = A[even];
                A[even] = A[odd]; // think about why "even" do not add 1
                A[odd--] = t; 
            } else {
                even++;
            }
        }
        return A;
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        Sort_Array_By_Parity service = new Sort_Array_By_Parity();
        int [] sss = service.sortArrayByParity(new int[] {3,1,2,4});
        for(int item : sss) {
            System.out.print(item+"->");
        }
    }
    
}