package com.playground.cache.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月30日 下午1:01:17
 */

public class UseLinkedHashMapCache<X, V> extends LinkedHashMap<X, V>{
	private int cacheSize;
	public UseLinkedHashMapCache(int cacheSize){
	 	super(16, 0.75f, true);
	 	this.cacheSize = cacheSize;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<X, V> eldest){
         return size() > cacheSize;
	}

	public static void main(String[]args){
		UseLinkedHashMapCache<Integer,String> cache = new UseLinkedHashMapCache<Integer,String>(4);
		cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.put(4, "four");
        cache.put(2, "two");
        cache.get(3);

		reversePrint(cache);
	}

	public static void reversePrint(LinkedHashMap<Integer,String> map) {
		Stack<String> msg = new Stack<>();
		for(Map.Entry<Integer, String> entry: map.entrySet()){
			msg.push(entry.getValue());
		}
		int orginSize = msg.size();
		for (int i=0; i < orginSize; i++) {
			System.out.println(msg.pop());
		}
	}
	
	
	

}
