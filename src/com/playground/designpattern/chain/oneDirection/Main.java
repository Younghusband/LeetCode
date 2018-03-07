package com.playground.designpattern.chain.oneDirection;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月6日 下午3:12:22
 * 
 * 责任链模式，单向过滤器
 * 
 * 实现单向的三种过滤， 表情过滤 :) -> ^-^ 
 *                   脚本过滤: <xxxx> -> [xxxx]
 *                   敏感信息过滤: "敏感" -> ""
 */

public class Main {
	
     public static void main(String[] args) {
    	 String msg = ":),<script>,敏感,被就业,网络授课";
    	 MessageProcessor p = new MessageProcessor();
    	 p.setMsg(msg);
    	 FilterChain chain = new FilterChain();
    	 chain.add(new SensitiveFilter()).add(new FaceFilter()).add(new HTMLFilter());
    	 p.setChain(chain);
    	 String result = p.process();  //process方法不入参更美
    	 System.out.println(result);
	}
     
}
