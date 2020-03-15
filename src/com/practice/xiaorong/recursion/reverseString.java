package com.practice.xiaorong.recursion;

public class reverseString {
    public static void main(String[] args) {
        char[] s = new char[]{'H','a','n','n','a','h'};
        reverseString(s);
    }
    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        reverse(start, end, s);
    }
    private static void reverse(int start, int end, char[] s) {
        if (start < end) {
            char t = s[start];
            s[start] = s[end];
            s[end] = t;

            start += 1;
            end -= 1;
            reverse(start, end, s);
        }

    }
}
