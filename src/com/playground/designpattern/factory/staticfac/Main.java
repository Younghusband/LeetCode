package com.playground.designpattern.factory.staticfac;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月1日 下午11:12:34
 */

public class Main {
	
	public static void main(String[] args) {
		Noodle n1 = StaticFactory.getLaMian();
		Noodle n2 = StaticFactory.getReGanMian();
		Noodle n3 = StaticFactory.getXiaoMian();
		
		n1.eated();
		n2.eated();
		n3.eated();
		
	}

}
