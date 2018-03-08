package com.playground.designpattern.chain.twoDirection;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月8日 下午3:07:50
 * 
 */

public interface Filter {
       void doFilter(Request request, Response response, FilterChain fc);
}
