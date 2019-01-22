package com.problems.code.easy;

/**
 * @author mr_yo
 * 
 * char A(65)~z(122)
 * 
 * 2nd 1st solution better
 * 
 * String is often handled from a char Perspective. Try not to use String's methods, that is so slow.
 */
/**
 * @author mr_yo
 *
 */
public class Jewels_and_Stones {
    
    public static void main(String[] args) {
       String J = "z";
       String S = "ZZ";
        
        Jewels_and_Stones service = new Jewels_and_Stones();
        System.out.println(service.numJewelsInStones(J, S));
    }
    
    
    /**
     * fastest solution
     */
    public int numJewelsInStones(String J, String S) {
       if(J == null || S == null || J.length() == 0 || S.length() == 0) return 0;
       boolean [] jMap = new boolean[128];  // z == 122  
       int count = 0;
       for(char j: J.toCharArray()) {
           jMap[j] = true;
       }
       
       for(char s: S.toCharArray()) {
           if(jMap[s]) count++;
       }
       return count; 
    }
    
    
    /**
     * the 2nd fast solution
     */
//    public int numJewelsInStones(String J, String S) {
//        char [] jewels = J.toCharArray();
//        char [] stones = S.toCharArray();
//        
//        int count = 0;
//        for (char jc : jewels) {
//            for(char st: stones) {
//                if (st == jc) {
//                    count++;
//                }
//            }
//        }
//       return count; 
//    }
    
    
    
    /**
     * my shit solution
     */
//    public int numJewelsInStones(String J, String S) {
//        int sum = 0;
//        if (J == null || J.equals("") || null == S || S.equals("")) {
//            return 0;
//        }
//        for (int i = 0; i < S.length(); i++) {
//            if (J.contains(String.valueOf(S.charAt(i)))) {
//                sum++;
//            }
//        }
//        return sum;
//    }
    
    
    
    

}
