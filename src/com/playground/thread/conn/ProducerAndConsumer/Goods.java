package com.playground.thread.conn.ProducerAndConsumer;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月27日 下午10:00:16
 * 
 * 商品
 */

public class Goods {
	private String id;
	private String name;
	
	public Goods(String id,String name){
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "{ id: "+id+"， name: "+name+" }";
	}

}
