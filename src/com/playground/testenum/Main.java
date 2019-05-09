package com.playground.testenum;


/**
 * 
 * 我依旧不是和能理解使用枚举的好处
 * 
 * */

public class Main {
	
	private TypeEnum type;
	
	public void setType(TypeEnum type) {
		this.type = type;
	}
	
	
	public static void main(String[] args) {
		Main main = new Main();
		main.setType(TypeEnum.IN_PROCESS_2);
		System.out.println(Type.B.getType());
	}
	
	
	
}
