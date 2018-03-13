package com.playground.thread.future;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月7日 下午5:09:09
 * 
 * Future模式的本质就是，利用多个线程工作。并将多线程透明化，一个线程先返回结果，另一个线程实际去加载要的东西
 * 
 */

public class Main {
	
	public static void main(String[] args) {
		Client client = new Client();
		Data data = client.request("请给我来一个hogtied girl");  //方法里面启动线程去完成realData的装载
		
		System.out.println("请求发送成功，做其他的事情了");   //这个地方可以替换业务代码
		System.out.println(data.getRequest());   //在这个方法阻塞住
		System.out.println("----");
	}

}
