package com.problems.code.medium;

import java.util.HashMap;
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
 *
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters x = new LongestSubstringWithoutRepeatingCharacters();
        String s = "pwwkew";
        System.out.println(x.lengthOfLongestSubstring(s));

    }

    /**
     * 利用hashMap 瞬间定位子串中重复字符出现的位置，并将i = location+1
     *
     * 其中 "a...a" 这种类型是个陷阱，需要 判断重复元素的下标是否大于当前i
     * 如果i大，则取i ...
     **/
    public int lengthOfLongestSubstring(String s){
         int i = 0,j=0,ans = 0, n = s.length();
         HashMap<Character,Integer> map = new HashMap<>();
         for(;j<n;j++){
             if(map.containsKey(s.charAt(j))){
                 i = Math.max(map.get(s.charAt(j)),i);
             }
             ans = Math.max(ans,j-i+1);
             map.put(s.charAt(j),j+1);
         }
         return ans;
    }


    /**
     * 这个方法的基本思想和我的方法是一样的
     *
     * 区别在于，我的检测到重复字符串的话就将j归到i的位置重新开始检测，这样大大浪费了很多的性能
     *
     * 而这个方法，如果我检测到新加入的字符在原有字符段中存在的话，将i往后挪1 j并不动
     *
     * 这样使得效率大大提高。
     *
     * 缺点:  不能一下子定位 新增的重复字符在无重复字符子串中的位置，从而浪费了i位移到正确位置的性能
     * 可用hashMap优化
     **/
    public int lengthOfLongestSubstring_window(String s){
        int i = 0, j = 0, ans = 0, n = s.length();
        HashSet<Character> window = new HashSet<>();
        while (j < n) {  // 无论如何j都比i大，所以不需要对i进行判断
            if (!window.contains(s.charAt(j))) {
                ans = Math.max(ans, j - i + 1);
                window.add(s.charAt(j++));
            } else {
                window.remove(s.charAt(i++));
            }
        }
        return ans;
    }




    /**
     * 可以用Math.max(a,b)来简化三元运算符
     * 可以用charAt(i）方法来省去  String的 toCharArray ..
     */
    public int lengthOfLongestSubstring_my(String s) {
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
        return (j - i) > max ? (j - i) : max;  //这里比较是为了防止max为0的情况
    }





    /**
     * 暴力法， 设置两个下标 [i,j)
     * 逐个遍历，检查是否有重复字符，需要配合 boolean allUniqueChar(str,start,end) 方法
     * 效率上弱于我的方法，因为存在着大量冗余的循环。。。
     *
     * 注意！ 这是LeetCode自己提供的方法，然后这方法太慢了竟然由于超时而无法AC
     **/
    public int editionSolution_poor_brute(String s) {
        int ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++)
                if (allUniqueChar(s, i, j)) ans = Math.max(ans, j - i);
        }
        return ans;
    }


    /**
     * @Description: 用于返回 字符串s在下标 i,j 范围内是否都是不重复字符
     * n方次遍历过程中每次都会new出来set  属于比较低效的方法。
     **/
    public boolean allUniqueChar(String s, int i, int j) {
        HashSet<Character> set = new HashSet<>();
        for (int x = i; x < j; x++) {
            if (set.contains(s.charAt(x))) return false;
            set.add(s.charAt(x));
        }
        return true;
    }


}
