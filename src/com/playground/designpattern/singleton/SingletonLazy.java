package com.playground.designpattern.singleton;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月21日 下午5:26:37
 * 
 * 
 *  懒汉式
 *  
 *  这种写法lazy loading很明显，但是致命的是在多线程不能正常工作。　
 */


public class SingletonLazy {
	private static SingletonLazy instance;
	private SingletonLazy(){};
	
	public static SingletonLazy getInstance() {
        if(instance == null){
        	instance = new SingletonLazy();
        }
		return instance;
	}

	/** 
	 * @Description: 阻塞过于严重  大多数情况下并不需要同步
	 * @Date: 2019/6/9 20:36
	 */
	synchronized public static SingletonLazy getInstancePro() {
		if(instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}

}
