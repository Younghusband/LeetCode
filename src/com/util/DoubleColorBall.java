package com.util;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;

/**
 * @author: Vermouth
 * @create: 2019-06-30 13:14
 * @description: nimabi
 **/

public class DoubleColorBall {

    private Set<Integer> redBalls;
    private transient Set<Integer> crushRandomInts;
    private Random random;
    private int blueBall;
    private int count = 0;
    private DoubleColorBall() {
        crushRandomInts = new TreeSet<>();
        redBalls = new TreeSet<>();
        random = new Random();
    }
    private static class Holder {
        private static DoubleColorBall INSTANCE = new DoubleColorBall();
    }

    public static DoubleColorBall getInstance() {
        return Holder.INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        DoubleColorBall.getInstance().roll();
    }

    public void roll() throws Exception{
        CountDownLatch latch = new CountDownLatch(2);
        Thread redT = new Thread(() -> {
            generateRed();
            latch.countDown();
        });
        Thread blueT = new Thread(() -> {
            generateBlue();
            latch.countDown();
        });
        redT.start();
        blueT.start();

        latch.await();
        printResult();
    }

    public void generateRed() {
        for(int i=1; i<= 6; i++) {
            int x = getRandom( 33);
            while(!redBalls.add(x)) {
                crushRandomInts.add(x); // 冲突元素记录
                x = getRandom( 33);
            }
        }
    }

    public void generateBlue() {
        blueBall = getRandom( 16);
    }

    public void printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("红球是: 【");
        Iterator<Integer> it = redBalls.iterator();
        while(it.hasNext()) {
            sb.append(it.next());
            if(it.hasNext()){
                sb.append(" ");
            }
        }
        sb.append("】，蓝球是: 【").append(blueBall).append("】\n");
        sb.append("总计random了【").append(count).append("】次\n");
        sb.append("random冲突元素:");
        if(crushRandomInts.size() == 0) {
            sb.append("无");
        } else {
            for(Object item : crushRandomInts.toArray()) {
                sb.append(item+" ");
            }
        }

        print(sb.toString());
    }

    public int getRandom(int limit){
        count++;
        return this.random.nextInt(limit) + 1;
    }

    public void print(String content) {
        System.out.printf("%s\n", content);
    }


}
