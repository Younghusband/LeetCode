package com.playground.backtracing;

/**
 * @author: Vermouth
 * @create: 2021-04-22 15:11
 * @description:
 **/

public class Bag {

    private static int maxW = Integer.MIN_VALUE; // 重量结果放到maxW中
    private static int maxV = Integer.MIN_VALUE; // 价值结果放到maxV中
    private int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private int[] value = {3, 4, 8, 9, 6}; // 物品的价值
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量
    private boolean[][] mem = new boolean[5][10]; // 备忘录，默认值false

    public void f(int i, int cw) { // 调用f(0, 0)
        if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
        if (cw > maxW) maxW = cw;
            return;
        }
        if (mem[i][cw]) return; // 重复状态
        mem[i][cw] = true; // 记录(i, cw)这个状态
        f(i+1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i+1,cw + weight[i]); // 选择装第i个物品
        }
    }

    public void f(int i, int cw, int cv) { // 调用f(0, 0, 0)
        if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
        if (cv > maxV) maxV = cv;
            return;
        }
        f(i+1, cw, cv); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i+1,cw+weight[i], cv+value[i]); // 选择装第i个物品
        }
    }

    public static void main(String[] args) {
        int i = 0;
        int w = 0;
        Bag bag = new Bag();
        bag.f(i,w);
        System.out.println("maxW=" + maxW);
    }
}
