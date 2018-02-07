package com.playground.thread.future;

import java.util.concurrent.TimeUnit;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月7日 下午5:11:54
 */

public class RealData implements Data{

	private String result;
	
	public RealData(String qryStr){
		System.out.println("根据 \""+ qryStr +"\"查询，这是一个很费时的操作。" );
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓操作完毕，获取结果↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		result = "a hogtied girl";
	}
	
	@Override
	public String getRequest() {
		// TODO Auto-generated method stub
		return result;
	}
	
	
	

}
