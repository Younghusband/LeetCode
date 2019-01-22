package com.playground.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mr_yo
 * playground
 */
public class ConcurrentTest {

    public static ConcurrentHashMap<String, AtomicInteger> concurrents = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        ConcurrentTest main = new ConcurrentTest();

        new Thread(
                () -> {
                    System.out.println("我插进来了");
                    try {
                        for (int i = 0; i < 20; i++) {
                            Thread.sleep(1000);
                            main.countDown("yangfan");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                , "down").start();

        for (int i = 0; i < 2; i++) {
            new Thread(
                    () -> {
                        try {
                            for (int j = 0; j < 5; j++) {
                                Thread.sleep(500);
                                main.countUp("yangfan");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    , "yf"+i).start();
        }

    }


    public void countUp(String pacs) {
        AtomicInteger count = concurrents.get(pacs);
        while (true) {
            if (null != count) {
                if (count.get() >= 10) {
                    sleep(1);
                    continue;
                }
                int i = count.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " countUp操作: 操作后的值为 " + i);
                break;
            }
            synchronized (getClass()) {
                if (null == concurrents.get(pacs)) {
                    concurrents.put(pacs, new AtomicInteger(1));
                    System.out.println(String.format(Thread.currentThread().getName() + " 往 %s 里 新建一个值 %s", pacs, concurrents.get(pacs).get()));
                } else {
                    int j = concurrents.get(pacs).incrementAndGet();
                    System.out.println(Thread.currentThread().getName() + " countUp解锁后操作: 操作后的值为 " + j);
                }
            }
            break;
        }
    }


    public void countDown(String pacs) {
        AtomicInteger count = concurrents.get(pacs);
        if (null != count && count.get() > 0) {
            System.out.println(Thread.currentThread().getName() + " countDown操作：操作后值为 " + count.decrementAndGet());
        }
    }

    public void sleep(int s) {
        try {
            TimeUnit.SECONDS.sleep(s);
            System.out.println("超载睡1秒");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
