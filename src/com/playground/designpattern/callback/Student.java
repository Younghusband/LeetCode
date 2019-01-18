package com.playground.designpattern.callback;


import lombok.Data;

/**
 * @author mr_yo
 * 
 * Student XiaoMing
 * 
 */

@Data
public class Student {
    
    public class StudentConsumer implements DoJob { // jus
        @Override
        public void fillBlank(int result, int [] params) {
            System.out.println(
                String.format("%s 计算出了 (%s + %s)的结果为 %s", name, params[0], params[1], result));
        }
    }
    
    private String name;
    public Student(String name) {
        this.name = name;
    }
    public void callHelp(int a, int b) {
        System.out.println(String.format("%s已经呼叫助手去做这个, 可以去做别的了。", this.name));
        new Calculator().call(new StudentConsumer(), a, b);
    }
    
    
}
