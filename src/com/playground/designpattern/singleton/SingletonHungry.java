package com.playground.designpattern.singleton;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月21日 下午7:55:08
 * 
 * 饿汉式  不存在线程不安全问题
 * 
 * 这种方式基于classloder机制避免了多线程的同步问题。
 * 不过，instance在类装载时就实例化，这时候初始化instance显然没有达到lazy loading的效果。
 * 
 * 问题来了，为啥要lazy loading这种效果呢？
 * 
 * 答: 单例会在加载类后一开始就被初始化，即使客户端没有调用 getInstance()方法。
 * 饿汉式的创建方式在一些场景中将无法使用：譬如 Singleton 实例的创建是依赖参数或者配置文件的，在 getInstance() 之前必须调用某个方法设置参数给它，
 * 那样这种单例写法就无法使用了。
 * 
 */

public class SingletonHungry {
	private static SingletonHungry instance = new SingletonHungry();
	//或者下面这种写法，感觉没有区别
	/***
	private static SingletonHungry instance = null;
	static{
		instance = new SingletonHungry();
	}   ***/

	private SingletonHungry(){}
	public static SingletonHungry getInstance(){
         return instance;		
	}
}



