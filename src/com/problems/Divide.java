package com.problems;

/**
 * @program: LeetCode
 * @description: 不用乘法除法取模来实现除法
 * @author: Vermouth
 * @create: 2019-06-05 17:09
 **/

public class Divide {


    public static void main(String[] args) {
        System.out.println(divide(5,4));
    }


    public static int divide(int big, int small) {
        int shang = 0;
        for (; ; ) {
            if (big - small >= 0) {
                shang++;
                big = big - small;
            } else
                break;
        }
        return shang;
    }

}
