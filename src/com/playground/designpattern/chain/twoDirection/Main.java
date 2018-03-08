package com.playground.designpattern.chain.twoDirection;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月8日 下午2:14:57
 * 
 * 
 */

public class Main {
	
        public static void main(String[] args) {
        	String msg = ":),<script>,敏感,被就业,网络授课";
        	Request request = new Request();
        	Response response = new Response();
        	FilterChain fc = new FilterChain();
        	
        	request.setRequestStr(msg);
        	response.setResponseStr("-----");
        	// ---HTML -> Face -> Sensitive
        	fc.addFilter(new HTMLFilter()).addFilter(new FaceFilter()).addFilter(new SensitiveFilter());
        	fc.setRequest(request);
        	fc.setResponse(response);
        	
        	fc.doFilter(request, response,fc);
        	System.out.println(request.getRequestStr());
        	System.out.println(response.getResponseStr());
		}
}
