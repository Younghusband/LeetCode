package com.practice.xiaorong;

/**
 * 最最简单动态规划
 */
public class No70 {
    public int climbStairs(int n) {
        int[] x = new int[n];
        x[0] = 1;
        x[1] = 1;
        for (int i = 2; i <= n; i++) {
            x[i] = x[i-1] +  x[i-2];
        }
        return x[n];
    }
}
