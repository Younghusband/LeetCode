package com.playground.designpattern.chain.twoDirection;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月8日 下午3:08:32
 */

public class FilterChain implements Filter{
    
	private Request request;
	private Response response;
	List<Filter> chain = new ArrayList<>();
	
	int index;
	public FilterChain(){
		index = 0;   //每次初始化的时候计数器归零
	}
	
	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
	 
	/**
	 * 添加过滤器
	 **/
	public FilterChain addFilter(Filter f){
		this.chain.add(f);
		return this;
	}
	
	/**
	 * 过滤处理类
	 **/
	@Override
	public void doFilter(Request request, Response response, FilterChain fc) {
		if(index==chain.size())  //当return的时候后面的操作我就不懂了
			return;
		
		Filter f = chain.get(index++);
			
		f.doFilter(request, response, fc);
	}
	

}
