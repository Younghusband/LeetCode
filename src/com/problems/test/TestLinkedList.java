package com.problems.test;

import java.util.LinkedList;

/**
 * @description
 * @author vermouth.Mac
 * @version 2018年2月22日 下午5:24:22
 */

public class TestLinkedList {
	public static void main(String[] args) {
         LinkedList<Integer> list = new LinkedList<Integer>();
         list.add(1);
         list.add(2);
         list.add(3);
         list.add(4);
         
//         list.pollLast();
         list.poll();
         
         
         System.out.println(list);
	}
}
