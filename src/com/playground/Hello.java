package com.playground;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月29日 下午5:23:06
 * 
 * 很经典的一道题目
 * 
 * 任何类的构造方法只有在 new XXX()的时候才会被调用。
 * 静态代码块最先执行，且针对该类只初始化一次。 
 * 
 * 每次new B() 都相当于调用一次print 2b
 * 
 * 所以答案是  1/a/2/b/2/b (每个都换行)
 */

public class Hello {
	
	public static void main(String[] args) {
		A ab = new B();
		ab = new B();
	}
}

class A{
	static{
		System.out.println("1");
	}
	public A(){
		System.out.println("2");
	}
}

class B extends A{
	static{
		System.out.println("a");
	}
	public B(){
		//相当于有个super(); 
		System.out.println("b");
	}
}
