package com.playground.designpattern.factory.staticfac;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月1日 下午11:12:25
 */

public class StaticFactory {
	
	
	public static LaMian  getLaMian(){
		return new LaMian();
	}
	
	public static ReGanMian  getReGanMian(){
		return new ReGanMian();
	}
	
	public static XiaoMian  getXiaoMian(){
		return new XiaoMian();
	}
	

}
