package com.playground.designpattern.iterator;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月20日 下午3:17:27
 */

public class LinkedListIterator implements Iterator {
	
	LinkedList list;  
	Node head;
	
	public LinkedListIterator(LinkedList list){
		this.list = list;
		head = list.head;   //这样的话，即便遍历完之后。原list还是可以用的，head节点还是在最开始
	}

	@Override
	public boolean hasNext() {
		return head!=null;
	}

	@Override
	public Object next() {
		Object o = head.val;
		head = head.next;
		return o;
	}

}
