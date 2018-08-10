package com.playground.designpattern.caller;

public class Caller {
    
    public void call(ICallBack callback) {
        System.out.println("--------ready to call--------");
        callback.callback();
        System.out.println("--------finish the call--------");
    }
    
    
    public static void main(String[] args) {
        Caller caller = new Caller();
                
        caller.call(new ICallBack() {    // 接口没法实例化就只能这样写咯~
            
            @Override
            public void callback() {
                System.out.println("回调成功");
            }
            
        });        
        
    }

}
