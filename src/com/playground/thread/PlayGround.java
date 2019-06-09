package com.playground.thread;

/**
 * @program: LeetCode
 * @description: no
 * @author: Vermouth
 * @create: 2019-05-26 16:08
 **/

public class PlayGround {

    public static void main(String[] args) {
        Runnable r = new MyThread();
        new Thread(r, "t1").start(); // thread t1 will start
        new Thread(r, "t2").start();
    }


}

class MyThread implements Runnable {
    public void run(){
//        synchronized (this) {
            for(int i=0; i<10; i++){
                System.out.println(Thread.currentThread().getName()+": "+ i);
            }
//        }
    }
}
