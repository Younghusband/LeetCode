package com.problems.code.medium;

import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters x = new LongestSubstringWithoutRepeatingCharacters();
        String s = "anviaj";
        System.out.println(x.lengthOfLongestSubstring(s));

    }


    /**
     * 可以用Math.max(a,b)来简化三元运算符
     * 可以用charAt(i）方法来省去  String的 toCharArray ..
     *
     */
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.isEmpty())
            return 0;
        char[] charArr = s.toCharArray();
        HashSet set = new HashSet();
        int i = 0, j = 0;
        int max = 0;
        while (j < charArr.length) {
            set.add(charArr[j]);
            j++;
            if (j == charArr.length) {
                break;
            }
            if (set.contains(charArr[j])) {
                max = (j - i) > max ? (j - i) : max;    //找到重复字符的时候先保存一下历史最长长度
                set.clear();                 //标尺头前移前记得删除历史元素
                i++;                                    //将标尺头后移，同时将标尺尾重新赋值
                j = i;
            }
        }
        return (j - i) > max ? (j - i) : max;
    }


    public int editionSolution(String s) {

        return 0;
    }


}
