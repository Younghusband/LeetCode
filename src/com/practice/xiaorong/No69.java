package com.practice.xiaorong;

public class No69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
    public static int mySqrt(int x) {

        int left = 1;
        int right = x / 2;
        if (right < left) {
            return x;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            long res = (long) mid * mid;
            if (res == x) {
                return mid;
            } else if (res < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
