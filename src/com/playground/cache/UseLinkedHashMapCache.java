package com.playground.cache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月30日 下午1:01:17
 */

public class UseLinkedHashMapCache<K,V> extends LinkedHashMap<K,V>{
	private int cacheSize;
	public UseLinkedHashMapCache(int cacheSize){
	 super(16,0.75f,true);    //那个f如果不加  就是double类型，然后该构造没有该类型的入参
	 this.cacheSize = cacheSize;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K,V> eldest){   //重写LinkedHashMap原方法
         return size()>=cacheSize;		
	}
	
	
	public static void main(String[]args){
		UseLinkedHashMapCache<Integer,String> cache = new UseLinkedHashMapCache<Integer,String>(4);
		cache.put(1, "one");
		cache.put(2, "two");
		cache.put(3, "three");
		cache.put(4, "four");
		cache.put(2, "two");
		cache.put(3, "three");
		
		
		Iterator<Map.Entry<Integer,String>> it = cache.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer, String> entry = it.next();
			Integer key = entry.getKey();
			System.out.print("Key:\t"+key);
			String Value = entry.getValue();  //这个无需打印...
			System.out.println();
		}
		
	}
	
	
	

}
