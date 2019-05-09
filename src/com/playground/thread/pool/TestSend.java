package com.playground.thread.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestSend {
    
    public void doSomeThing() {
        if(!send()) {
            System.out.println("先返回了？");
        } else {
            System.out.println("返回了");
        }
    }

    public boolean send() {
        int ret = 0;
        ExecutorService exec = Executors.newFixedThreadPool(1);
        Future<Integer> future = exec.submit(() -> {
            justKillTime(5); // 耗时操作
            return 1;
        });
        try {
            ret = future.get(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("超时了呢");
            e.printStackTrace();
        }
        return ret == 1;
    }
    
    
    public void justKillTime(int seconds) {
        try {
            System.out.println("等待10秒钟");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        TestSend service = new TestSend();
        service.doSomeThing();
    }
    
    
}
