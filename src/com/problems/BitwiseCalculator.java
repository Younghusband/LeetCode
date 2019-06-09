package com.problems;

/**
 * @program: LeetCode
 * @description: 利用位运算实现加减乘除
 * @author: Vermouth
 * @create: 2019-06-06 21:20
 *
 **/

public class BitwiseCalculator {

    public static void main(String[] args) {
        BitwiseCalculator a = new BitwiseCalculator();
        System.out.printf("加法(递归方式), %s\n", a.addByRecursive(5, 6));
        System.out.printf("加法(迭代方式), %s\n", a.addByIteration(5, 6));

        System.out.printf("减法，%s\n", a.minus(10, 5)); // 10 - 5
        System.out.printf("乘法，%s\n", a.multiply(10, -5)); // 10 * 5

    }

    /**
     * @Description:  递归加法
     * @Date: 2019/6/9 16:21
     */
    public int addByRecursive(int num1, int num2) {
        if(num2 == 0) {
            return num1;
        }
        int sum = num1 ^ num2;  // 仅仅加各位，不考虑进位
        int carry = (num1 & num2) << 1; // 仅仅只考虑进位后的值，不考虑相加的值
        return addByRecursive(sum, carry);
    }

    /** 
     * @Description:  迭代加法
     * @Date: 2019/6/9 16:21
     */
    public int addByIteration(int num1, int num2) {
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        for( ;carry != 0; ){
            int tmp = sum;
            sum = sum ^ carry;
            carry = (tmp & carry) << 1;
        }
        return sum;
    }

    /**
     * @Description: 减法  num1 - num2
     * @Date: 2019/6/9 16:35
     */
    public int minus(int num1, int num2) {
        return addByIteration(num1, addByIteration(~num2, 1)); // 取反加一 才是完成正负切换的完整流程
    }
    
    
    /** 
     * @Description: 乘法 a*b 
     * @Date: 2019/6/9 16:51
     */
    public int multiply(int a, int b) {
        int multiplicand = a >= 0 ? a : addByIteration(~a, 1);
        int multiplier = b >= 0 ? b : addByIteration(~b, 1);

        int product = 0; // 返回的乘积
        int count = 0; // 加法计算的次数

        while (count < multiplier) {
            product = addByIteration(product, multiplicand);
            count = addByIteration(count, 1);
        }
        if ((a ^ b) < 0) { // 判断两个数同号异号最快的方式，提示: 负数最高位为1
            product = addByIteration(~product, 1);
        }
        return product;
    }









}
