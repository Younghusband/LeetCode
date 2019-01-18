package com.playground.designpattern.callback;

public class CallBackTest implements CallBack.ICallback{
    
    private CallBack callback;
    
    public CallBackTest() {
        callback = new CallBack(this);
    }
    
    
    @Override
    public void before() {
        // TODO Auto-generated method stub
       System.out.println("yf before...");
    }

    @Override
    public void after() {
        // TODO Auto-generated method stub
       System.out.println("yf after...");
    }
    
    public void doThing() {
        callback.doThing();
    }
    
    public static void main(String[] args) {
        new CallBackTest().doThing();
    }

}
