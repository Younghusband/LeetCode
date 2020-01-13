package com.practice.xiaorong;
/**
 * @author xiaorongxu@clubfactory.com
 * @date 2020-01-11 15:32
 */
public class num7 {
    public int reverse(int x) {
        int reversedValue = 0;
        while (x != 0) {
            int currentNum = x % 10;
            x = x / 10;
            if (reversedValue > Integer.MAX_VALUE / 10 || reversedValue < Integer.MIN_VALUE / 10) {
                return 0;
            }
            reversedValue = reversedValue * 10 + currentNum;
        }
        return reversedValue;
    }
}
