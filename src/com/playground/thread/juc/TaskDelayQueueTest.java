package com.playground.thread.juc;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author mr_yo
 * 
 * 用于实现Delayqueue
 */
public class TaskDelayQueueTest { 
    
    private static DelayQueue<DelayedTask> delayQueue = new DelayQueue<>();
    
    public static void main(String[] args) throws InterruptedException {
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                
//                delayQueue.offer(new DelayedTask(11111, 20));
//                delayQueue.offer(new DelayedTask(11112, 10));
//                delayQueue.offer(new DelayedTask(11113, 15));
//                delayQueue.offer(new DelayedTask(11114, 5));
                delayQueue.offer(new DelayedTask(11115, 1));
//                delayQueue.offer(new DelayedTask(11116, 25));
//                delayQueue.offer(new DelayedTask(11117, 10));
//                delayQueue.offer(new DelayedTask(11118, 30));
            }
        }).start();
        System.out.printf("【%s】 开始运行", Thread.currentThread().getName());
        while(true) {
            if(delayQueue.size() == 0) {
                System.out.printf("【%s】 延迟队列中没有元素，请等待30分钟", Thread.currentThread().getName());
                TimeUnit.MINUTES.sleep(30);
            }
            DelayedTask take = delayQueue.take();
            System.out.println(take);
        }
        
    }
    
}
