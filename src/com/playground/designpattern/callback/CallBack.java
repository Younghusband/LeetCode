package com.playground.designpattern.callback;

import java.util.concurrent.TimeUnit;

public class CallBack {
    
    // just for defining interfaces
    public interface ICallback { // static or not is the same
        public void before();
        public void after();
    }
    
    private ICallback iCallback;
    
    public CallBack(ICallback icallback) {
        this.iCallback = icallback;
    }
    
    public void doThing() {
        iCallback.before();
        System.out.println("time-consuming operation...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        iCallback.after();
    }
    
}
