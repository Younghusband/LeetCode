package com.playground.designpattern.iterator;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月19日 下午7:28:43
 * 
 * 
 * 模拟arraylist的功能
 */

public class ArrayList implements Collection {
    
	private static final int INITIAL = 10;
	Object [] arr = new Object [INITIAL];
	int index = 0;
	@Override
	public void add(Object o) {
		 if(index==arr.length){//没坑了 扩容！
			 Object [] temp = new Object[arr.length*2];
			 System.arraycopy(arr, 0, temp, 0, arr.length);
			 arr = temp;
		 }
        arr[index++] = o;
	}
	
	@Override
	public Iterator iterator() {
		return new ArrayListIterator(this);  //把arrayList的参数传进去
	}
	
	public int size(){
		return index;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0;i<arr.length;i++){
			if(i!=arr.length-1)
				sb.append(arr[i]+",");
			else
				sb.append(arr[i]+"]");
		}
		return sb.toString();
	}


}
