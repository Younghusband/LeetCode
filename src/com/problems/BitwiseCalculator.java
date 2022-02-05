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

        System.out.printf("减法，%s\n", a.minus(10, 5));
        System.out.printf("乘法，%s\n", a.multiply(10, -5));
        System.out.printf("乘法pro，%s\n", a.multiplyPro(10, -5));
        System.out.printf("除法，%s\n", a.divide(10, 5));
        System.out.printf("除法pro，%s\n", a.dividePro(10, -5));

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
    // test
    
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

    /** 
     * @Description: 位运算乘法 优化版
     *               优化了当乘号右侧的数非常大的时候的累加次数
     *
     * @Date: 2019/6/10 21:22
     */
    public int multiplyPro(int a, int b) {
        int multiplicand = a >= 0 ? a : addByIteration(~a, 1);
        int multiplier = b >= 0 ? b : addByIteration(~b, 1);

        int product = 0;

        while(multiplier > 0) {
            if((multiplier & 1) == 1) {
                product = addByIteration(product, multiplicand);
            }
            multiplicand <<= 1;
            multiplier >>= 1;
        }

        if((a ^ b) < 0){
            product = addByIteration(~product, 1);
        }
        return product;
    }

    /**
     * @Description: 位运算实现除法
     * @Date: 2019/6/10 21:33
     */
    public int divide(int a, int b) {
        if(b == 0)
            throw new RuntimeException("除数不能为零。");
        if(a == 0)
            return a;

        int dividend = a > 0 ? a : addByIteration(~a, 1);
        int divisor = b > 0 ? b : addByIteration(~b, 1);

        int quotient = 0;
//        int reminder = 0;
        while(dividend >= divisor) {
            quotient = addByIteration(quotient, 1);
            dividend = minus(dividend, divisor);
        }

        if((a^b) < 0) {
            quotient = addByIteration(~quotient, 1);
//            reminder = addByIteration(~dividend, 1);
        }

        return quotient;
    }
    
    /** 
     * @Description: 位运算除法，优化的是除数远小于被除数时过多的减法运算
     * @Date: 2019/6/10 21:52
     */
    public int dividePro(int a, int b) {
        if (b == 0)
            throw new RuntimeException("除数不能为零。");
        if (a == 0)
            return 0;

        int dividend = a > 0 ? a : addByIteration(~a, 1);
        int divisor = b > 0 ? b : addByIteration(~b, 1);

        int quotient = 0;
        for (int i = 31; i >= 0; i--) { // 减小步长，上来就用最大步长来减
            if ((dividend >> i) >= divisor) {
                quotient = addByIteration(quotient, 1 << i);
                dividend = minus(dividend, divisor << i);
            }
        }
        if ((a ^ b) < 0) {
            quotient = addByIteration(~quotient, 1);
        }
        return quotient;
    }








}
