package com.practice.xiaorong;

public class No58 {
    public static void main(String[] args) {
        lengthOfLastWord("hello world");
    }
    public static int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        if (index < 0) {
            return 0;
        }
        int count = 0;
        do {
            if (s.charAt(index) == ' ' && count == 0) {
                continue;
            } else if (s.charAt(index) == ' ') {
                return count;
            } else{
                count ++;
            }
        } while ((index--) > 0);
        return count;
    }
}
