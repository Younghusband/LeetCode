package com.playground.designpattern.factory.abstractFactory;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月22日 上午10:01:15
 */

public interface AbsFactory {
	
	IFood provideFood();
    IDrink provideDrink();
	
}
