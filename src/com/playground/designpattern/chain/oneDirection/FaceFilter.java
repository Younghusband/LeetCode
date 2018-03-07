package com.playground.designpattern.chain.oneDirection;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月6日 下午3:48:03
 */

public class FaceFilter implements Filter {

	@Override
	public String doFilter(String str) {
		String result = str.replace(":)", "^-^");
		System.out.println("---------------"+this.getClass().getSimpleName()+"---------------");
		return result;
	}

}
