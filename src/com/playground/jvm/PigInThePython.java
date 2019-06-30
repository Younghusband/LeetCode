package com.playground.jvm;


import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 测试吞吐量
 * @author: Vermouth
 * @create: 2019-06-23 19:39
 *
 * 运行需谨慎
 * https://deepinmind.iteye.com/blog/2118983
 **/

public class PigInThePython {

    static volatile List pigs = new ArrayList();
    static volatile int pigEaten = 0;
    static final int ENOUGH_PIGS = 50;

    public static void main(String[] args) {
        new PigEater().start();
        new PigDigester().start();
    }


    static class PigEater extends Thread {

        @Override
        public void run() {
            while(true) {
                if(pigEaten >= ENOUGH_PIGS) { // 由消化者来控制？
                    return;
                }
                pigs.add(new byte[1 * 1024 * 1024]);
                takeANap(20);
            }
        }
    }


    static class PigDigester extends Thread {

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            while(true) {
                if (pigEaten > ENOUGH_PIGS)  {
                    System.out.format("Digested %d pigs in %d ms.%n",pigEaten, System.currentTimeMillis()-start);
                    return;
                }
                pigEaten += pigs.size();
                pigs = new ArrayList();
                takeANap(2000);
            }
        }
    }

    static void takeANap(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
