package com.playground.algorithm;

import java.util.Random;



public class Reservoir_Sampling {
    
    
    /**
     * 单机版蓄水池
     */
    public int[] getReservoir(int M, int[] veryBigArray) {
        int[] reservoir = new int[M];
        Random ran = new Random();
        // init reservoir
        for (int i = 0; i < M; i++) {
            reservoir[i] = veryBigArray[i];
        }
        for (int i = M; i < veryBigArray.length; i++) {
            // 获得一个[0, i]内的随机整数
            int luckBoy = ran.nextInt(i + 1);
            // 如果获得的整数在蓄水池的index范围内， 则替换蓄水池中的元素为 xxx[i]
            if (luckBoy < M) {
                reservoir[luckBoy] = veryBigArray[i];
            }
        }
        return reservoir;
    }
    
    
    public static void main(String[] args) {
        
    }
}
