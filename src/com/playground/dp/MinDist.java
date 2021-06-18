package com.playground.dp;

/**
 * @author: Vermouth
 * @create: 2021-04-23 11:01
 * @description:
 **/

public class MinDist {

    private static int[][] MATRIX = {{1,3,5,9}, {2,1,3,4},{5,2,6,7},{6,8,4,3}};
    private static int N = 4;
    private static int[][] MEM = new int[4][4];

    /**
     * 根据状态转移方程 得到的代码
     *
     * 传入要获得的矩阵坐标，获得该点的最短路径
     */
    public int minDist(int i, int j) {
        if (i == 0 && j == 0) return MATRIX[0][0];
        if (MEM[i][j] > 0) return MEM[i][j];
        int minLeft = Integer.MAX_VALUE;
        if (j-1 >= 0) {
            minLeft = minDist(i, j-1);
        }
        int minUp = Integer.MAX_VALUE;
        if (i-1 >= 0) {
            minUp = minDist(i-1, j);
        }
        int currMinDist = MATRIX[i][j] + Math.min(minLeft, minUp);
        MEM[i][j] = currMinDist;
        return currMinDist;
    }

    /**
     * 根据状态转移表 得到的代码
     */
    public int minDistDP1(int[][] matrix, int n) {
        int[][] states = new int[n][n];
        int sum = 0;
        for (int j = 0; j < n; ++j) { // 初始化states的第一行数据
            sum += matrix[0][j];
            states[0][j] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; ++i) { // 初始化states的第一列数据
            sum += matrix[i][0];
            states[i][0] = sum;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                states[i][j] = matrix[i][j] + Math.min(states[i][j-1], states[i-1][j]);
            }
        }
        return states[n-1][n-1];
    }




    public static void main(String[] args) {
        int n = 4; // 4*4
        MinDist dist = new MinDist();
        dist.minDistDP1(MATRIX, n);
    }
}
