package com.playground.designpattern.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: LeetCode
 * @description: test all singleton instance
 * @author: Vermouth
 * @create: 2019-06-09 21:24
 **/

public class Main {
    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(SingletonInnerClass.getInstance());
            }
        };

        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");
        Thread t3 = new Thread(r, "t3");


        t1.start();
        t2.start();
        t3.start();


        Map<String, Integer> map = new HashMap<>();
        map.put(null, 3);
        System.out.println(map.get(null));

        Map<String, Integer> cmap = new ConcurrentHashMap<>();
        cmap.put(null, 4);
        System.out.println(cmap.get(null));



    }
}
