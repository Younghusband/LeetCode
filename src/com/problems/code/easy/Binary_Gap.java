package com.problems.code.easy;

/**
 * @author mr_yo
 *
 * 868. Binary Gap
 *
 * 这道题目理解起来会有些费劲。
 * 简单的说，就是计算连续出现的‘1’和下一个‘1’ 之间的最大距离
 * 官方的描述都过于愚蠢了
 * 
 * 何为连续的‘1’ 
 * 比如 111010111  这里面前三个连续的‘1’距离都为1, 第三个与第四个‘1’之间的距离就是2... 以此类推
 * 
 * 通过这道题学到的:
 * 1. 通过右移的方式(>>1 然后&1)能够不断的获取10进制数字的各个2进制位(而不用将10进制转换为2进制）
 *
 * 2020.1.10
 * 1. 纠正方法#binaryGapByIndex的根本性错误, 并优化。
 * 2. 删除弱智解法
 */
public class Binary_Gap {

    public static void main(String[] args) {
        Binary_Gap service = new Binary_Gap();
        System.out.println(service.binaryGapByLast(22));
        System.out.println(21 & 3);
    }

    /**
     * 101101
     * >>1 10110 ; 10110 & 1 == 0 ; 不记录下标
     * >>2 1011  ; 1011 & 1 == 1 ; 记录下标
     * ... 
     * 然后通过这种方式记录下 N的2进制数字的所有‘1’ 位
     */
    public int binaryGapByIndex(int n) {
        int [] bitArr = new int[32]; // 极端情况下会占满, 即32位各位上都是‘1’
        int t = 0;
        for(int i = 0; i < 32; i++) {
            if (((n >> i) & 1) != 0) { // key code 该位有值且为1
                bitArr[t++] = i;
            }
        }
        int gap = 0;
        for(int i = 0; i < t-1; i++) {
            gap = Math.max(bitArr[i+1] - bitArr[i], gap);
        }
        return gap;
    }
    
    /**
     * 比 binaryGapByIndex 更优秀的方法。
     * 删减了 存储1出现位数的数组
     * 改用last存储最高位的下标
     */
    public int binaryGapByLast(int n) {
        int last = -1, gap = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) != 0) {
                if (last >= 0)
                    gap = Math.max(gap, i - last);
                last = i;
            }
        }
        return gap;
    }

}
