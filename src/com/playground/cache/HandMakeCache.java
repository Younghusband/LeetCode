package com.playground.cache;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月30日 下午2:33:54
 * 
 * 
 * 
 */

public class HandMakeCache {
	
	private int size;
	private LinkedList<HashMap<Integer,String>> cache;
	
	public HandMakeCache(int size){
		this.size = size;
		cache = new LinkedList<HashMap<Integer,String>>();
	}
	
	public void put(){
       
		 
	}
	
	
	
	
	
	
	public boolean isRemove(){
		return cache.size()>size;  
	}
	
	
	
	

}
