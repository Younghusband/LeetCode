package com.problems.code.easy;

import java.util.HashMap;
import java.util.Map;

/************************************************
    * Description: 
    *   Given an array of integers, return indices of the two numbers such that they add up to a specific target.
        You may assume that each input would have exactly one solution.
    * 
    *  哈哈哈  我这属于 Brute Force . 比较慢
    * 
    * 
    * @author    杨帆  
    * @version  1.0
    * @date ：2017年1月12日 下午5:20:46 
**************************************************/
public class Two_Sum {
	
    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        arr = twoSum666(arr, 9);
        for (int i : arr)
            System.out.print(i + "->");
    }

    /**
     * Brute-force
     * 
     */
    public static int[] twoSum_brute(int[] nums, int target) {
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    /**
     *  two-pass hashTable   
     * 
     */
    public static int[] twoSum_twopass(int[] nums, int target) {
        Map<Integer, Integer> value_index = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            value_index.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (value_index.containsKey(c) && value_index.get(c) != i) { //防止当前遍历元素刚好是target的一半而返回自身坐标
                return new int[] { i, value_index.get(c) };
            }
        }
        throw new IllegalArgumentException("No two sum solution.");
    }

    /**
     * one-pass hashTable
     * 
     * 边放边找的思路是很赞的
     */
    public static int[] twoSum_onepass(int[] nums, int target) {
        Map<Integer, Integer> value_index = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (value_index.containsKey(c) && value_index.get(c) != i) {
                return new int[] { i, value_index.get(c) };
            } else {
                value_index.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution.");
    }

    /**
     * 速度超快这种
     * 
     * 当时在论坛里找到的方法，现在已经找不到原帖子了。
     * 
     * 但是由于数组过小，在新的测试用例下 这个是AC不了的
     */
    public static int[] twoSum666(int[] nums, int target) {
        int[] map = new int[16030]; // 62kb
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i] + 5; // 给了一个5的缓冲
            if (diff < 0)
                continue; // 不在范围内
            if (map[diff] > 0) { // 在map数组中
                return new int[] { map[diff] - 1, i };
            }
            map[nums[i] + 5] = i + 1; // 放入map数组中
        }
        throw null;
    }

}
