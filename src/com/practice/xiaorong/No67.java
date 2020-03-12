package com.practice.xiaorong;

import org.omg.CORBA.MARSHAL;

public class No67 {
    public static void main(String[] args) {
        System.out.println(addBinary("100", "110010"));

    }
    public static String addBinary(String a, String b) {

        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();

        int minSize = Math.min(a1.length, b1.length);
        int maxSize = Math.max(a1.length, b1.length);

        StringBuilder sb = new StringBuilder();

        int flag = 0;
        for (int i = maxSize - 1, j = minSize - 1; i >= 0; i--, j--) {
            int currentSum;
            if (a1.length > b1.length) {
                if (j >= 0) {
                    currentSum = ((a1[i] - '0') + (b1[j] - '0') + flag);
                } else {
                    currentSum = ((a1[i] - '0') + flag);
                }
            } else {
                if (j >= 0) {
                    currentSum = ((a1[j] - '0') + (b1[i] - '0') + flag);
                } else {
                    currentSum = ((b1[i] - '0') + flag);
                }
            }
            flag = currentSum >= 2 ? 1 : 0;
            currentSum = currentSum % 2;
            sb.insert(0, currentSum);
        }
        if (flag == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
