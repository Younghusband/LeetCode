package com.playground.thread.lock;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月5日 下午10:17:24
 * 
 * 
 */

public class DeadLock {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";
    public static void main(String[] args){
        Thread a = new Thread(new Lock1(),"Lock1");
        Thread b = new Thread(new Lock2(),"Lock2");
        a.start();
        b.start();
    }    
}
class Lock1 implements Runnable{
    @Override
    public void run(){
        try{
            System.out.println("Lock1 running");
//            while(true){
                synchronized(DeadLock.obj1){   //lock1 锁住了obj1 等待obj2
                    System.out.println(Thread.currentThread().getName()+" lock obj1");
                    Thread.sleep(3000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
                    synchronized(DeadLock.obj2){  //双方卡在这里
                        System.out.println(Thread.currentThread().getName()+" lock obj2");
                    }
                }
//            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class Lock2 implements Runnable{
    @Override
    public void run(){
        try{
            System.out.println("Lock2 running");
//            while(true){
                synchronized(DeadLock.obj2){   //lock2锁住了obj2 等待obj1
                    System.out.println(Thread.currentThread().getName()+" lock obj2");
                    Thread.sleep(3000);
                    synchronized(DeadLock.obj1){
                        System.out.println(Thread.currentThread().getName()+" lock obj1");
                    }
                }
//            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}