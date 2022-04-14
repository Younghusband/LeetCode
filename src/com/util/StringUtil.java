package com.util;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringUtil {
    
    /**
     * @param src
     * @return
     * 
     * 将xxx_xxx 的形式转变为驼峰
     */
    public static String changeUnderline2Hump(String src) {
        String[] arr = src.split("_");
        String returnStr = "";
        if (arr.length <= 1) {
            return src;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                String allUpper = arr[i].toUpperCase();
                arr[i] = allUpper.substring(0, 1)
                    .concat(arr[i].substring(1, arr[i].length()));
            }
            returnStr = returnStr.concat(arr[i]);
        }
        return returnStr;
    }

    public static void printDigitArray(String delimiter, int ... t) {
        List<Integer> intList = Arrays.stream(t).boxed().collect(Collectors.toList());
        StringJoiner sj = new StringJoiner(delimiter, "[", "]");
        intList.forEach(
            s -> sj.add(s+"")
        );
        System.out.println(sj.toString());
    }

    
}
