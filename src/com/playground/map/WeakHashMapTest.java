package com.playground.map;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author mr_yo
 *
 */
public class WeakHashMapTest {
    
    
    public static void main(String[] args) {
        Map<String, String> map = new WeakHashMap<>();
        map.put("yangfan", "1million");
        Collections.synchronizedMap(map);
        
        System.out.println(map.size());
        
    }

}
