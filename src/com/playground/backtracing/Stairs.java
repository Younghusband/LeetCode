package com.playground.backtracing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Vermouth
 * @create: 2021-04-23 15:25
 * @description:
 **/

public class Stairs {

    private Map<Integer, Integer> mem = new HashMap<>();
    public int f(int n) {
        if(n == 1|| n == 2) {
            return n;
        }
        else {
            if(mem.get(n) != null) {
                return mem.get(n);
            }
            mem.put(n, f(n-1) + f(n-2));
            return f(n-1) + f(n-2);
        }
    }

    public static void main(String[] args) {
        Stairs sss = new Stairs();
        System.out.println(sss.f(5));
    }

}
