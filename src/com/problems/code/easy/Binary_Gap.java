package com.problems.code.easy;

/**
 * @author mr_yo
 * 
 * 这道题目理解起来会有些费劲。
 * 
 * 简单的说，就是计算连续出现的‘1’和下一个‘1’ 之间的最大距离
 * 
 * 官方的描述都过于愚蠢了。
 * 
 * 何为连续的‘1’ 
 * 
 * 比如 111010111  这里面前三个连续的‘1’距离都为1, 第三个与第四个‘1’之间的距离就是2... 以此类推 
 * 
 * 通过这道题学到的:
 * 1. 通过右移的方式能够不断的获取10进制数字的各个2进制位(而不用将10进制转换为2进制）
 * 2. 
 */
public class Binary_Gap {
    
    /**
     * 101101
     * >>1 10110 ; 10110 & 1 == 0 ;不记录下标
     * >>2 1011  ; 1011 & 1 == 1;记录下标
     * ... 
     * 然后通过这种方式记录下 N的2进制数字的所有‘1’ 位
     */
    public int binaryGapByIndex(int N) {
        int [] bitArr = new int[32]; // 极端情况下会占满, 即32位各位上都是‘1’
        int t = 0;
        for(int i=0; i<32; i++) 
            if (((N >> i) & 1) != 0)  // key code
                bitArr[t++] = i;
        
        int gap = 0;
        for(int i=0; i<t-1; i++) {
            gap = Math.max(bitArr[i+1], bitArr[i]);
        }
        return gap;
    }
    
    /**
     * 比 binaryGapByIndex 更优秀的方法。
     * 删减了 存储1出现位数的数组
     * 改用last存储最高位的下标
     */
    public int binaryGapByLast(int N) {
        int last = -1, gap = 0;
        for (int i = 0; i < 32; i++) {
            if (((N >> i) & 1) != 0) {
                if (last >= 0)
                    gap = Math.max(gap, i - last);
                last = i;
            }
        }
        return gap;
    }
    
    public static void main(String[] args) {
        Binary_Gap service = new Binary_Gap();
        
        System.out.println(service.transferDecimal2BinaryStr(0));
        System.out.println(service.transferDecimal2BinaryStr(16));
        System.out.println(service.transferDecimal2BinaryStr(999));
        
        System.out.println("-------------------------------------");
        
        System.out.println(service.binaryGap(6));
        
        System.out.println(4&1);
        System.out.println(-4>>>1);
        
    }
    
    /**
     * 我的解法
     * 
     * 先转化为2进制字符串，然后再对2进制字符串进行操作是非常冗余的操作
     */
    public int binaryGap(int N) {
        String xxx = transferDecimal2BinaryStr(N);
        char [] charArr = xxx.toCharArray();
        int locate = 0;
        int gap = 0;
        for(int i=0; i<charArr.length; i++) {
            if(charArr[i]=='1') { // everytime we meet character '1'
                gap = Math.max(gap, i-locate);
                locate = i;
            }
        }
        return gap;
    }
    
    public String transferDecimal2BinaryStr(int xxx) {
        String str = "";
        while (xxx > 0) {
            str = xxx % 2 + str;
            xxx = xxx / 2;
        }
        return str.equals("") ? "0" : str;
    }

}
