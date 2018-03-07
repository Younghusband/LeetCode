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
 */

public class FilterChain {
	
	private List<Filter> chain;
	
	public FilterChain(){
		chain = new ArrayList<Filter>();
	}
	
	public List<Filter> getChain() {
		return chain;
	}

	public void setChain(List<Filter> chain) {
		this.chain = chain;
	}

	
	public FilterChain add(Filter f){
		this.chain.add(f);
		return this;
	}
	
	public String process(String str){
		String result = str;
		for(Filter f: chain){
			result = f.doFilter(result);
		}
		return result;
	}

}
