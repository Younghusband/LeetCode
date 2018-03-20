package com.playground.designpattern.iterator;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月19日 下午6:12:09
 */

public interface Collection {
	
     public void add(Object o);
     
     public Iterator iterator();
     
     public int size();
     
}
