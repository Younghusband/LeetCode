package com.playground.function;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @author mr_yo
 * Lambda表达式的测试
 * 
 * 核心思路就是  (params) -> statement
 * 
 */
public class MyLambda {
    
    public void lambda() {
        ActionListener listener = event -> System.out.println("button clicked");
        /**
         * 代码块
         */
        Runnable block = () -> {

            System.out.println("Lambda 代码块******");
            System.out.println("Lambda 代码块******");
        };
        BinaryOperator<Long> add = (Long x, Long y) -> x + y;
        /**
         * 5 类型推断
         */
        BinaryOperator<Long> infer = (x, y) -> x + y;//
    }
    
    public static void guiMethod() {
        JButton show =  new JButton("Show");
        show.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                   System.out.println("without lambda expression is boring");
                   System.out.println("xxxx");
                }
             });
        
        // better way below
        show.addActionListener((e) ->  {
            System.out.println("without lambda expression is boring");
            System.out.println("xxxx");
        });
        
    }
    

    public static void main(String[] args) {
        // 首先Thread里面的入参是接口，然后接口里面也只有一个未实现方法，所以才能用lambda推测出这个方法
        new Thread(() -> System.out.println("Thread run********")).start();

        List<String> strList = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//        strList.forEach(n -> System.out.println(n));   // Even better use Method reference feature of Java 8
        strList.forEach(System.out::println);  // Better way
        
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        // insertion sort
        

    }
    

}
