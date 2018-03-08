package com.playground.designpattern.chain.twoDirection;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月8日 下午3:09:14
 */

public class HTMLFilter implements Filter {
	
	@Override
	public void doFilter(Request request, Response response,FilterChain fc) {
          request.requestStr = request.getRequestStr().replace("<", "[").replace(">", "]");
          
          fc.doFilter(request, response, fc);  //当方法走到头的时候 这个方法才会跳过里面的Return
          
          response.responseStr += "HTMLFilter---->";
	} 

}
