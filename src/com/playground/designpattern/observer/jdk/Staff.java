package com.playground.designpattern.observer.jdk;

import java.util.Observable;

import lombok.Data;


/**
 * @author mr_yo
 * 
 * jdk实现的Observer
 * 
 * 缺点1: nofity之前还要setChanged? 搞毛
 * 缺点2: 通知所有观察者时是串联的，会有阻塞的问题
 * 缺点3: 观察者对象的update方法的入参不是很明白为什么要传【被观察者的父类对象】
 */
@Data
public class Staff extends Observable {
    
    private String staffState;
    
    public Staff() {
        this.staffState = "初始状态"; 
    }
    
    public void changeStaffSomeState(String newState) {
        this.staffState = newState;
        setChanged(); // 标注这个被观察者发生了改变，让观察者采取措施
        notifyObservers("员工有动静！！");
    }

}
