package com.playground.designpattern.factory.abstractFactory;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月22日 上午10:10:00
 */

public class ColaDrink implements IDrink {

	@Override
	public void drink() {
		System.out.println("我在喝可乐，可乐好好喝！！");
	}

}
