package com.playground;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mr_yo
 * playground
 */
public class Main {
    
    public static void main(String[] args) {
        AtomicInteger messageID = new AtomicInteger();
        System.out.println(messageID.incrementAndGet()& '￿');  // 这里是粘出来的 不是空字符
        System.out.println(3333&'￿');
        
    }

}
