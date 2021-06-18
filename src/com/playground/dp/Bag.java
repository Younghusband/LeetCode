package com.playground.dp;

/**
 * @author: Vermouth
 * @create: 2021-04-22 17:18
 * @description:
 **/

public class Bag {

    private static int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private static int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private static int[] value = {3, 4, 8, 9, 6}; // 物品价值
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

    // weight:物品重量, n:物品个数, w:背包可承载重量
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w+1]; // 默认值false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) { //1. 不把第i个物品放入背包
                if (states[i-1][j] == true) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-weight[i]; ++j) { //2. 把第i个物品放入背包
                if (states[i-1][j]==true) states[i][j+weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n-1][i] == true) return i;
        }
        return 0;
    }

    // weight:物品重量, value:物品价值, n:物品个数, w:背包可承载重量
    public int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; ++i) { // 初始化states
            for (int j = 0; j < w+1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; ++i) { //动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                if (states[i-1][j] >= 0) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-weight[i]; ++j) { // 选择第i个物品
                if (states[i-1][j] >= 0) {
                    int v = states[i-1][j] + value[i];
                    if (v > states[i][j+weight[i]]) {
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n-1][j] > maxvalue) maxvalue = states[n-1][j];
        }
        return maxvalue;
    }

    public static void main(String[] args) {
        Bag bag = new Bag();
//        System.out.println(bag.knapsack(weight, 5, 9));
        System.out.println(bag.knapsack3(weight, value, 5, 9));
    }

}
