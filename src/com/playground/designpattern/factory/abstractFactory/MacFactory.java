package com.playground.designpattern.factory.abstractFactory;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月22日 上午10:15:17
 * 
 * 麦当劳 提供  食物:汉堡   饮料:可乐
 */

public class MacFactory implements AbsFactory {

	@Override
	public IFood provideFood() {
		return new BurgerFood();
	}

	@Override
	public IDrink provideDrink() {
		return new ColaDrink();
	}

}
