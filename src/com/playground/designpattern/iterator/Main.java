package com.playground.designpattern.iterator;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月19日 下午3:10:13
 * 
 * 模拟iterator模式
 */

public class Main {
	
	
	public static void main(String[] args) {
		Collection list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add("xxx");

		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + "->");
		}
		System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(list.size());

		// 测试linkedList
		Collection link = new LinkedList();
		link.add("yf");
		link.add(3);
		link.add(2.5f);
		link.add("6666");

		Iterator ik = link.iterator();
		while (ik.hasNext()) {
			System.out.print(ik.next() + "->");
		}
		System.out.println("\n" + link.size());

		// Node tmp = link.head;
		// while(tmp!=null){
		// System.out.print(tmp.val+"->");
		// tmp = tmp.next;
		// }

	}
}
