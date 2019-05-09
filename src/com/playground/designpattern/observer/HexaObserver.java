package com.playground.designpattern.observer;

public class HexaObserver extends Observer{
    
    public HexaObserver(BeWatched watched) {
        this.sb = watched;
        this.sb.attach(this);
    }
    
    @Override
    void update() {
        System.out.println(String.format("Hex String:  %s", Integer.toHexString(sb.getState())));
    }

}
