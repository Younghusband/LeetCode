package com.playground.thread.future;


/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月7日 下午5:11:39
 */

public class FutureData implements Data {
	
	private RealData realdata;
	private boolean isReady = false;
	
	public synchronized void setRealData(RealData realdata){
	    System.out.println(Thread.currentThread().getName()+"-----setRealData");
		if(isReady){
			return;
		}
		
		this.realdata = realdata;
		isReady = true;
		notify();
	}
	
	
    /**
     * 如果在装载前就走到这个方法的话，wait那个地方必不可少
     * 
     * */
	@Override
	public synchronized  String getRequest() {  //关键字的添加不影响实现接口
		System.out.println(Thread.currentThread().getName()+"-----getRequest");
		while(!isReady){   //如果没准备好
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return this.realdata.getRequest();
	}
	
	
	
	
	

}
