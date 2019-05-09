package com.playground.designpattern.observer;

public class OctalObserver extends Observer{

    public OctalObserver(BeWatched watched) {
        this.sb = watched;
        this.sb.attach(this);
    }
    
    @Override
    public void update() {
        System.out.println(String.format("Octal String:  %s", Integer.toOctalString(sb.getState())));
    }

}
