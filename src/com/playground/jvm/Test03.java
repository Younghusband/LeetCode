package com.playground.jvm;

import java.util.Vector;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月10日 下午8:55:40
 * 
 * 模拟OOM
 */

public class Test03 {
	
      public static void main(String[] args) {
    	  // -Xms2m  -Xmx2m  -XX:+HeapDumpOnOutofMemoryError  -XX:HeapDumpPath=/Users/Younghusband/Ruby/Test03.dump
    	  Vector v = new Vector();
    	  for(int i=0; i < 5; i++){
    		  v.add(new Byte[1*1024*1024]);
    	  }
		
	}
}
