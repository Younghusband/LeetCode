package com.playground.designpattern.observer.jdk;

public class Main {

    public static void main(String[] args) {
        Staff s1 = new Staff();
        s1.addObserver(new MyObserver());
        s1.changeStaffSomeState("去你妈的老子不干了");
    }
    
}
