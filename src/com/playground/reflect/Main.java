package com.playground.reflect;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Car car = (Car)Class.forName("com.playground.reflect.Car").newInstance();
        car.run();
    }
}
