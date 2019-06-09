package com.playground.designpattern.singleton;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月21日 下午7:48:48
 * 
 * 懒汉式 双重校验锁
 * 
 * 锁优化  不会锁整个方法
 * 
 * 为什么在同步块内还要再检验一次？
 * 因为可能会有多个线程（各个线程均处于instance==null的状态）一起进入同步块外的
 * 其中有一个线程拿到了锁初始化了instance, 其他排队的线程进来需要再次判断if(instance == null)
 * 从而保证了不会重复创建实例
 * 
 * 这段代码看起来很完美，很可惜，它是有问题。主要在于instance = new SingletonLazyPro()这句，这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情。

	给 instance 分配内存
	调用 SingletonDemo3 的构造函数来初始化成员变量
	将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
	
	但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。
	如果是后者，线程一在 3 执行完毕、2 未执行之前，被线程二抢占了，这时 instance 已经是非 null 了（但却没有初始化），所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。
	我们只需要将 instance 变量声明成 volatile 就可以了。
 * 
 *  使用 volatile 的主要原因是其另一个特性：禁止指令重排序优化
 */

public class SingletonLazyPro {
	
	private volatile static SingletonLazyPro instance;
	private SingletonLazyPro() {}

	public static SingletonLazyPro getInstance() {
		if (instance == null) {
			synchronized (SingletonLazyPro.class) {
				if (instance == null) {   //这个地方我不是很理解
					instance = new SingletonLazyPro();
				}
			}
		}
		return instance;
	}
	

}
