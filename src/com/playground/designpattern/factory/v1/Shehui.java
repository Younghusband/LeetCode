package com.playground.designpattern.factory.v1;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月22日 下午6:03:42
 * 
 * 简单静态工厂类，缺点很明显：   如果要新增类型的话就需要修改方法，耦合过高
 */

public class Shehui implements God {
	
	private static final String WORKER = "worker";
	private static final String PROGRAMMER = "programmer";

	@Override
	public People zaoRen(String type) {
		switch(type){
		case WORKER:
			return new Worker();
		case PROGRAMMER:
			return new Programmer();
		default:
			return null;
		}
	}

}
