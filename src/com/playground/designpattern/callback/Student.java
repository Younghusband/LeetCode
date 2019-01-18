package com.playground.designpattern.callback;


import lombok.Data;

/**
 * @author mr_yo
 * 
 * Student XiaoMing
 * 
 * 
 */

@Data
public class Student {
    private String name;
    public Student(String name) {
        this.name = name;
    }
    
    /**
     * 寻求别人帮助
     */
    public void callHelp(int a, int b) {
        System.out.println(String.format("%s已经呼叫助手去做这个, 可以去做别的了。", this.name));
        new Calculator().call(new StudentConsumer(), a, b);
    }
    
    public class StudentConsumer implements DoJob {
        @Override
        public void fillBlank(int result, int [] params) {
            System.out.println(
                String.format("%s 计算出了 (%s + %s)的结果为 %s", name, params[0], params[1], result));
        }
    }
    
    /**
     * 计算 a+b的值
     * 让第三方去掉用
     * */
    @SuppressWarnings("unused")
    public void fillBlank(int a, int b, int result) {
//        int result = add(a, b);
        System.out.println(
            String.format("%s 计算出了 (%s + %s)的结果为 %s", this.name, a, b, result));
    }
    @SuppressWarnings("unused")
    public int add(int a, int b) {
        return new Calculator().add(a, b);
    }

}
