package com.playground.designpattern.observer;


public abstract class Observer {
    protected BeWatched sb;
    abstract void update(); // when some events are observed
}
