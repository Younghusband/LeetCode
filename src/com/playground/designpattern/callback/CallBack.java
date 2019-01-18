package com.playground.designpattern.callback;

public class CallBack {
    
    private ICallback iCallback;
    
    public CallBack(ICallback icallback) {
        this.iCallback = icallback;
    }
    
    public static interface ICallback {
        public void before();
        public void after();
    }
    
    public void doThing() {
        iCallback.before();
        System.out.println("main do things...");
        iCallback.after();
    }
    
}
