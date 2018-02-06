package com.playground.designpattern.singleton;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月21日 下午8:56:44
 * 
 * 静态内部类 static nested class
   这种方法也是《Effective Java》上所推荐的。
   
   这种写法仍然使用JVM本身机制保证了线程安全问题；
   由于 SingletonHolder 是私有的，除了 getInstance() 之外没有办法访问它，因此它是懒汉式的；同时读取实例的时候不会进行同步，没有性能缺陷；也不依赖 JDK 版本。
 * 
 */

public class Singleton {
	private static class SingletonHolder {
		private static Singleton Instance = new Singleton();
	}
	private Singleton(){}
	public static Singleton getInstance(){  //这个方法是不需要final的 因为实际上也不能被继承
		return SingletonHolder.Instance;
	}
		
}



