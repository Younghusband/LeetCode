package com.practice.xiaorong;

public class num38 {
    public static void main(String[] args) {
        countAndSay(1);
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder("1");
        for (int i = 1; i < n; ++i) {
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < sb.length(); ++j) {
                int count = 0;
                char c = sb.charAt(j);
                while (j < sb.length() && sb.charAt(j) == c) {
                    count += 1;
                    j+=1;
                }
                sb2.append(count).append(c);
                j--;
            }
            sb = new StringBuilder(sb2.toString());
        }
        return sb.toString();
    }
}
