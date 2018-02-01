package com.playground.designpattern.factory.v2;

import com.playground.designpattern.factory.v1.People;
import com.playground.designpattern.factory.v1.Programmer;
import com.playground.designpattern.factory.v1.Worker;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月23日 上午12:00:22
 * 
 * 利用反射的静态工厂
 * 
 * 不谈reflection的效率还有以下问题：
1 个人觉得不好，因为Class.forName(clz.getName()).newInstance()调用的是无参构造函数生成对象，
   它和new Object()是一样的性质，而工厂方法应该用于复杂对象的初始化 ，当需要调用有参的构造函数时便无能为力了，这样像为了工厂而工厂。
2 不同的产品需要不同额外参数的时候 不支持。
 */

public class Main {
	
	public static void main(String[] args) {
		
		People p1 = ReflectFactory.zaoRen(Programmer.class);
		People p2 = ReflectFactory.zaoRen(Worker.class);
		p1.produce();
		p2.produce();
		
	}

}
