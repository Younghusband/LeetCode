package com.playground.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:  实现OOM
 *
 * 创建对象时如果没有可以分配的堆内存，JVM就会抛出OutOfMemoryError:java heap space异常。
 *
 * https://blog.csdn.net/u011983531/article/details/63250882
 *
 * 还没搞完，稍后继续
 *
 **/

public class TestOOM {

    private static int count = 0;

    public static void main(String[] args) {
        //        oom();
        try {
            stackOverFlow();
        } finally {
            System.out.printf("递归调用%s次\n", count);
        }

    }


    public static void oom() {
        long start = System.currentTimeMillis();
        List<byte []> list = new ArrayList();
        for(int i =1; i < 100000; i++) {
            list.add(new byte[5*1024*1024]);
            System.out.printf("分配第%s次\n", i);
        }
    }


    public static void stackOverFlow() {
        count++;
        stackOverFlow();
    }





}
