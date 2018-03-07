package com.playground.designpattern.chain.oneDirection;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月6日 下午5:47:46
 */

public class SensitiveFilter implements Filter{

	@Override
	public String doFilter(String str) {
		String result = str.replace("敏感", "  ").replace("被就业", "就业");
		System.out.println("---------------"+this.getClass().getSimpleName()+"---------------");
		return result;
	}

}
