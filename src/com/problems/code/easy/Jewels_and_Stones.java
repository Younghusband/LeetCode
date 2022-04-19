package com.problems.code.easy;

/**
 * @author mr_yo
 * 771. Jewels and Stones
 * char A(65)~z(122)
 * 
 * 2nd 1st solution better
 * 
 * String is often handled from a char Perspective. Try not to use String's methods, that is so slow.
 */
public class Jewels_and_Stones {
    
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        
        System.out.println(numJewelsInStones(J, S));
//        System.out.println("z".charAt(0));

    }
    
    
    /**
     * fastest solution
     * key points:
     * 1. char not Char
     * 2. char as array index(char auto convert to ascii int value)
     * 3. do things one-path o(n)
     */
    public static int numJewelsInStones(String jewels, String stones) {
       if(jewels == null || stones == null || jewels.length() == 0 || stones.length() == 0) return 0;
       boolean [] jMap = new boolean[128];  // z == 122
       int count = 0;
       for(char j: jewels.toCharArray()) {
           jMap[j] = true;  // 核心在于 char 进数组中自动转ascii码了
       }

       for(char s: stones.toCharArray()) {
           if(jMap[s]) count++;
       }
       return count;
    }

    /**
     * however 比较慢
     */
//    public static int numJewelsInStones(String jewels, String stones) {
//        String rules = "[^"+jewels+"]";
//        stones = stones.replaceAll(rules, "");
//        return stones.length();
//    }
    
    
    /**
     * 这种会浪费每一次遍历stones
     */
//    public static int numJewelsInStones(String jewels, String stones) {
//        char [] jChars = jewels.toCharArray();
//        char [] sChars = stones.toCharArray();
//        int count = 0;
//        for (char jc : jChars) {
//            for(char st: sChars) {
//                if (st == jc) {
//                    count++;
//                }
//            }
//        }
//       return count;
//    }

}
