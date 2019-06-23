package com.playground.jvm.classload;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 测试类加载
 * @author: Vermouth
 * @create: 2019-06-23 12:55
 **/

public class ClassLoaderTest {

    public static void main(String[] args) {
        NoOne yf = new NoOne();
        ClassLoader yfLoader = yf.getClass().getClassLoader();
        System.out.println(yfLoader); // appClassLoader加载
        System.out.println("------------app loader---------------");
        Class loaderSuper = yfLoader.getClass();
        printRelation(loaderSuper);
        System.out.println("-------------ext loader--------------");
        // 由于appClassloader不是以继承的方式来实现父子关系的，需要用getParent的方式来获得extClassLoader
        Class parentLoader = yfLoader.getParent().getClass();
        printRelation(parentLoader);
    }

    public static void printRelation(Class cl) {
        Stack<Class> appRelation = new Stack<>();
        while(cl != null) {
            appRelation.push(cl);
            cl = cl.getSuperclass();
        }
        int count = 0;
        int initialSize = 0;
        while(!appRelation.empty()){
            initialSize = initialSize == 0 ? appRelation.size() : initialSize;
            count = count == 0 ? initialSize : count;
            for(int i = count; i < initialSize; i++)
                System.out.print(' ');
            System.out.printf("%s\n", appRelation.pop());
            count--;
        }
    }

}

class NoOne {
    private String name;
    public NoOne() {
        this.name = "no one";
    }
    public void speak() {
        System.out.printf("my name is %s", this.name);
    }
}
