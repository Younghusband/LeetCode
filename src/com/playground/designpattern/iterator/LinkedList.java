package com.playground.designpattern.iterator;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月19日 下午11:56:43
 */

public class LinkedList implements Collection{
    
	int count = 0;
    Node head = null;
    Node tail = null;  //只是添加的时候方便

	@Override
	public void add(Object o) {
		Node n = new Node();
		n.val = o;  // n.next = null;
		if(head==null) {
			head = n;
			tail = n;
		}else{
			tail.next = n;
			tail = n;
		}
		count++;
	}

	@Override
	public Iterator iterator() {
		return new LinkedListIterator(this);
	}

	@Override
	public int size() {
		return count;
	}
	
}

class Node {
	Object val;
	Node next;
}
