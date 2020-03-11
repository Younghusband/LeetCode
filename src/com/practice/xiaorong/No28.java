package com.practice.xiaorong;

/**
 * @author xiaorongxu@clubfactory.com
 * @date 2020-01-11 15:51
 */
public class No28 {

    public static void main(String args[]){
        System.out.println(strStr("aaa","a"));
    }

    public static int strStr(String haystack, String needle) {

        char[] haystackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();

        if (needleChar.length == 0) {
            return 0;
        }

        int index = -1;
        for (int i = 0; i <= haystackChar.length - needle.length(); i++) {
                if (haystackChar[i] == needleChar[0]) {
                    index = i;
                    for (int j = 1; j < needleChar.length; j++) {
                        if (haystackChar[i+j] != needleChar[j]) {
                            index = -1;
                        }
                    }
                    if (index >= 0) {
                        return index;
                    }
                }

        }
        return index;
    }


};

