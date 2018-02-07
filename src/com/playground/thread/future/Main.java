package com.playground.thread.future;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月7日 下午5:09:09
 */

public class Main {
	
	public static void main(String[] args) {
		Client client = new Client();
		Data data = client.request("请给我来一个hogtied girl");  //去完成realData的装载
		
		System.out.println("请求发送成功，做其他的事情了");
		System.out.println(data.getRequest());
	}

}
