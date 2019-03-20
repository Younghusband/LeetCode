package com.playground.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月30日 下午1:01:17
 */

public class UseLinkedHashMapCache<X,V> extends LinkedHashMap<X,V>{
	private int cacheSize;
	public UseLinkedHashMapCache(int cacheSize){
	 super(16, 0.75f, true);    //那个f如果不加  就是double类型，然后该构造没有该类型的入参
	 this.cacheSize = cacheSize;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<X,V> eldest){   //重写LinkedHashMap原方法
         return size() > cacheSize;	//不包含等于条件
	}
	
	
	public static void main(String[]args){
		UseLinkedHashMapCache<Integer,String> cache = new UseLinkedHashMapCache<Integer,String>(4);
		cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.put(4, "four");
        cache.put(2, "two");
        cache.put(3, "three");
		
//		
//		for(Integer key : cache.keySet()){
//			   System.out.println("Key:\t"+key);
//			}
		
		for(Map.Entry<Integer, String> entry: cache.entrySet()){
			System.out.println("Key:\t"+entry.getKey());
		}
		
	}
	
	
	

}
