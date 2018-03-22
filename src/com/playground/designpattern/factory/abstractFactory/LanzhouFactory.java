package com.playground.designpattern.factory.abstractFactory;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月22日 上午10:14:03
 * 
 * 拉州拉面馆提供    食物:拉面   饮料:水
 */

public class LanzhouFactory implements AbsFactory {

	@Override
	public IFood provideFood() {
		return new LamianFood();
	}

	@Override
	public IDrink provideDrink() {
		return new WaterDrink();
	}

}
