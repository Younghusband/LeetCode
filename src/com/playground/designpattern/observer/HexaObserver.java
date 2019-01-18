package com.playground.designpattern.observer;

public class HexaObserver extends Observer{
    
    public HexaObserver(Subject sb) {
        this.sb = sb;
        this.sb.attach(this);
    }
    
    @Override
    void update() {
        System.out.println(String.format("Binary String:  %s", Integer.toHexString(sb.getState())));
    }

}
