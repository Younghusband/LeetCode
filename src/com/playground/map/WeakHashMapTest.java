package com.playground.map;

import java.lang.ref.WeakReference;
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
        Map<String, String> weakMap = new WeakHashMap<>();
        
        String key1 = "wc1";
        String key2 = "wc2";
        String key3 = "wc3";
        
        weakMap.put(key1, "key1");
        weakMap.put(key2, "key2");
        weakMap.put(key3, "key3");
        
        System.out.printf("\nweakMap:%s\n", weakMap);
        
        System.out.printf("contains key1 : %s\n", weakMap.containsKey(key1));
        System.out.printf("contains key2 : %s\n", weakMap.containsKey(key2));
        System.out.printf("contains key3 : %s\n", weakMap.containsKey(key3));
        
        System.out.printf("contains value 0 : %s\n", weakMap.containsValue(new Integer(0)));
        
        
//        weakMap.remove("3");
//        System.out.printf("\nweakMap:%s\n", weakMap);
        
        
        // ---- 测试 WeakHashMap 的自动回收特性 ----
        System.out.println("置为弱引用后。。。");
        key1 = null;
        key2 = null;
        key3 = null;
        System.gc();
        Iterator<Map.Entry<String, String>> iter = weakMap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, String> en = iter.next();
            System.out.printf("next : %s - %s\n",en.getKey(),en.getValue());
        }
        
        System.out.printf(" after gc WeakHashMap size:%s\n", weakMap.size());
        
        
        WeakReference<String> sr = new WeakReference<String>(new String("hello"));
        
        System.out.println(sr.get());
        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(sr.get());
        
    }

}
