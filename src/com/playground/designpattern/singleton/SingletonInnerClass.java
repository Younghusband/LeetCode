package com.playground.designpattern.singleton;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月21日 下午8:56:44
 * 
 * 静态内部类 static nested class
   这种方法也是《Effective Java》上所推荐的。
   
   这种写法仍然使用JVM本身机制保证了线程安全问题；
   内部类SingletonHolder只有在getInstance()方法第一次调用的时候才会被加载（实现了延迟加载效果）；
   同时读取实例的时候不会进行同步，没有性能缺陷；也不依赖 JDK 版本。

   是不是可以说静态内部类单例就是最完美的单例模式了呢？
   其实不然，静态内部类也有着一个致命的缺点，就是传参的问题。
   由于是静态内部类的形式去创建单例的，故外部无法传递参数进去。
   例如Context这种参数，所以，我们创建单例时，可以在静态内部类与懒汉DCL模式里自己斟酌。
 * 
 */

public class SingletonInnerClass {
	private static class SingletonHolder {
		private static SingletonInnerClass Instance = new SingletonInnerClass();
	}
	private SingletonInnerClass() {}
	public static SingletonInnerClass getInstance() { //这个方法是不需要final的 因为实际上也不能被继承
		return SingletonHolder.Instance;
	}
}



