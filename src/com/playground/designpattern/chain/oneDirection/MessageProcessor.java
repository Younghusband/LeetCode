package com.playground.designpattern.chain.oneDirection;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月6日 下午5:02:09
 */

public class MessageProcessor {
	private String msg;
	/***version 1
	//数组装对象，实现有序调用
	Filter [] filterChain = {new HTMLFilter(),new FaceFilter(),new SensitiveFilter()};  //不停添加filter
	***/
	private FilterChain chain;
	
    public FilterChain getChain() {
		return chain;
	}

	public void setChain(FilterChain chain) {
		this.chain = chain;
	}

	public String process(){
    	return this.chain.doFilter(msg);
    }
    
    public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
