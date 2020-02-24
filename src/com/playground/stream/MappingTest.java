package com.playground.stream;

import com.google.common.collect.Lists;
import com.playground.stream.entity.Apple;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MappingTest {

    public static void main(String[] args) {

        List<Apple> sourceList
                = Lists.newArrayList(new Apple("red",1), new Apple("red",2), new Apple("blue", 2));

        Map<String, List<Apple>> groupingByResult =
        sourceList.stream().collect(
                Collectors.groupingBy(
                    Apple::getColor
                )
        );

        List<String> mappingResult =
        sourceList.stream().collect(
            Collectors.mapping(
                Apple::getColor, Collectors.toList()
            )
        );

        Map<String, List<Integer>> gmResult =
        sourceList.stream().collect(
            Collectors.groupingBy(
                Apple::getColor,
                Collectors.mapping(
                    Apple::getWeight, Collectors.toList() // 也可以Collectors.toSet()
                )
            )
        );


        System.out.println(groupingByResult);
        System.out.println(mappingResult);
        System.out.println(gmResult);

    }

}
