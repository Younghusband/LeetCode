package com.playground.designpattern.callback;

/**
 * @author mr_yo
 * 验证回调方法的 单纯的测试类
 */
public class Test {
    
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        
        Student s1 = new Student("小明");
//        s1.fillBlank(a, b);
        s1.callHelp(a, b);
        
        
        int [] prices = {23423,2523523,33,5555,21};
        
        Seller s2 = new Seller("杨老板");
        s2.callKidHelp(prices);
    }

}
