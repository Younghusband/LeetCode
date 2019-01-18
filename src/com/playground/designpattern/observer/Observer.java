package com.playground.designpattern.observer;


public abstract class Observer {
    protected Subject sb;
    abstract void update(); // when some events are observed
}
