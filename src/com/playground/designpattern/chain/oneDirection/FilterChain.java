package com.playground.designpattern.chain.oneDirection;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月8日 上午12:24:05
 * 
 * 过滤器链
 * 
 * 实现filter接口是为了将filterChain作为整体能够add进别的已有的filterChain
 */

public class FilterChain implements Filter{ 
	
	private List<Filter> chain = new ArrayList<>();;
	
	public FilterChain add(Filter f){
		this.chain.add(f);
		return this;
	}
	
	@Override
	public String doFilter(String str){
		String result = str;
		for(Filter f: chain){
			result = f.doFilter(result);
		}
		return result;
	}

}
