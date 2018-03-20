package com.playground.designpattern.iterator;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月19日 下午11:28:46
 */

public class ArrayListIterator implements Iterator {
	
	ArrayList list;
	Object [] arr;
	
	static int count;
	
	public ArrayListIterator(ArrayList list){
		this.list = list;
		this.arr = list.arr;
		count = 0;  //初始位置
	}

	@Override
	public boolean hasNext() {  //元素满了之后add才会扩容，所以对于饱和的数组存在着数组越界情况
		if(count==list.size()) return false;
		return arr[count]!=null;
	}

	@Override
	public Object next() {
		return arr[count++];
	}

}
