package com.playground.designpattern.singleton;

import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 三例
 * @author: Vermouth
 * @create: 2019-06-25 15:10
 **/

public class TripleTon {

    private int id;
    private TripleTon(int id){ this.id = id; }
    private static List<TripleTon> instances =
            Arrays.asList(new TripleTon(0), new TripleTon(1), new TripleTon(2));

    public static TripleTon getInstance(int id) {
        return instances.get(id);
    }

}
