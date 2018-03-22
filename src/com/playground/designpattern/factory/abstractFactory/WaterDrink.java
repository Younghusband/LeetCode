package com.playground.designpattern.factory.abstractFactory;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月22日 上午10:10:41
 */

public class WaterDrink implements IDrink {

	@Override
	public void drink() {
		System.out.println("穷人只能喝水了TAT");

	}

}
