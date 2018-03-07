package com.playground.designpattern.chain.oneDirection;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月6日 下午5:50:45
 */

public class HTMLFilter implements Filter {

	@Override
	public String doFilter(String str) {
		String result = str.replace("<", "[").replace(">", "]");
		System.out.println("---------------"+this.getClass().getSimpleName()+"---------------");
		return result;
	}

}
