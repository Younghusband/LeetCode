package com.playground.stream;

import com.google.common.collect.Lists;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {
//        List<Integer> oddList = Lists.newArrayList();
//        List<Integer> evenList = Lists.newArrayList();
//
//        Consumer<Integer> storeNumber = n -> {
//            if(n%2 == 0) {
//                evenList.add(n);
//            } else {
//                oddList.add(n);
//            }
//        };
//
//        storeNumber.accept(25);
//        storeNumber.accept(20);
//        storeNumber.accept(12);
//        storeNumber.accept(23);
//
//        Consumer<List<Integer>> printList = list -> list.forEach(s -> System.out.println(s));
//        System.out.println("----------- Odd number -----------");
//        printList.accept(oddList);
//        System.out.println("----------- Even number -----------");
//        printList.accept(evenList);

        List<String> needProcessData = Lists.newArrayList("ABC", "BBC", "CBA", "DDB", "APPLE", "BANANA");
        circleOperation(needProcessData, list -> list.forEach(s -> System.out.println(s)), 2);
    }



    /**
     * 自己分段执行
     */
    public static <PARAM> void circleOperation(List<PARAM> needProcessData, Consumer<List<PARAM>> consumer, Integer circleSize) {
        List<List<PARAM>> partionData = Lists.partition(needProcessData, circleSize);
        partionData.forEach(s -> {
            consumer.accept(s);
            System.out.println("-------------");
        });
    }


}
