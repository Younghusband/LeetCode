package com.playground.designpattern.chain.twoDirection;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月6日 下午5:47:46
 */

public class SensitiveFilter implements Filter{

	@Override
	public void doFilter(Request request, Response response,FilterChain fc) {
		 request.requestStr = request.getRequestStr().replace("敏感", " ").replace("被", "");
		 
		 fc.doFilter(request, response, fc);
		 
		 response.responseStr += "SensitiveFilter---->";
	}


}
