package com.problems.code.easy;


/**
 * @author mr_yo
 * 
 * 说不上来收获了啥，就是觉得解法很骚。
 */
public class Sort_Array_By_ParityII {
    public static void main(String[] args) {
          Sort_Array_By_ParityII service = new Sort_Array_By_ParityII();
          int [] arr = {1,4,2,5,6,9};
          int [] xxx = service.sortArrayByParityII(arr);
//          
//          for(int i = 0; i<xxx.length ; i++) {
//              System.out.print(xxx[i]+"->");
//          }
//          System.out.println();
//          
//          System.out.println(3&0x1);
          
          
          arr[0] = arr[0]^arr[1];
          arr[1] = arr[0]^arr[1];
          arr[0] = arr[0]^arr[1];
          
          System.out.println(arr[0]);
          System.out.println(arr[1]);
    }

    /**
     * one-pass and two-direction solution
     * 
     * i -> ... -< j
     */
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (true) {
            for (; i < A.length && (A[i]&1) == 0; i += 2) { // 找到第一个偶数位是奇数的 i

            }
            for (; j >= 0 && (A[j]&1) == 1; j -= 2) { // 找到最后一个奇数位是偶数的j

            }
            if (i >= A.length || j < 0) {
                break;
            }
            int t = A[i];
            A[i] = A[j];
            A[j] = t;
            // 换过了以后，此时A[i] & 1 == 0; A[j] & 1 == 1;
        }
        return A;
    }
    
    /**
     * two-pass solution
     */
    public int[] sortArrayByParityIISimple(int[] A) {
        if (null == A || A.length == 0)
            return A;

        int[] result = new int[A.length];
        int t = 0;
        for (int even : A) if (even % 2 == 0) {
                result[t] = even;
                t += 2;
            }
        t = 1;
        for (int odd : A) if (odd % 2 == 1) {
                result[t] = odd;
                t += 2;
            }
        return result;
    }
    
    /**
     * 官方解答
     * 
     * 精髓在于j 为什么不会数组越界。 
     * 提示: 数组一半奇数，一半偶数
     */
    public int[] sortArrayByParityIIEdition(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2)
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1)
                    j += 2;

                // Swap A[i] and A[j]
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

        return A;
    }
    
    
    
    
}
