package com.playground.designpattern.observer;

public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.sb = subject;
        this.sb.attach(this);
    }
    
    @Override
    void update() {
        System.out.println(String.format("Binary String:  %s", Integer.toBinaryString((sb.getState()))));
    }

}
