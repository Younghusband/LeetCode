package com.playground.designpattern.chain.oneDirection;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月6日 下午3:47:20
 */

public interface Filter {
	//对字符串的处理，如果用void 则值无法回传给调用者
       public String doFilter(String str);
}
