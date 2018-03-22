package com.playground.designpattern.factory.abstractFactory;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月22日 上午10:11:10
 */

public class BurgerFood implements IFood{

	@Override
	public void eat() {
		System.out.println("正在吃巨无霸汉堡！");
	}

}
