package com.practice.xiaorong;

import java.util.Arrays;

public class No66 {

    public static void main(String[] args) {
        int[] t = new int[5];
        for (int i = 0; i < t.length; i++) {
            System.out.printf(String.valueOf(t[i]));
        }
        System.out.printf(Arrays.toString(plusOne2(new int[]{9,9,8,9})));
    }
    public static int[] plusOne(int[] digits) {
        boolean carryFlag = false;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (i == digits.length - 1) {
                digits[i] = digits[i] + 1;
            } else if (carryFlag) {
                digits[i] += 1;
            }
            if (digits[i] >= 10) {
                carryFlag = true;
                digits[i] %= 10;
            } else {
                carryFlag = false;
            }
        }
        int[] res = digits;
        if (carryFlag) {
            res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < digits.length; ++i) {
                res[i] = digits[i];
            }
        }
        return res;
    }
    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            digits[i] += 1;
            // 说明没有进位
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 默认都是0
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
