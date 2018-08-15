package com.playground.testenum;

public enum TypeEnum {
	
	/**
	 * 0-已处理
	 */
	PROCESSED_0("已处理", 0), 
	/**
	 * 1-未处理
	 */
	SUNTREATED_1("未处理", 1), 
	/**
	 * 2-处理中
	 */
	IN_PROCESS_2("处理中", 2);
	
	private String desc;
	private int value;
	
	TypeEnum(String desc, int value){
		this.desc = desc;
		this.value = value;
	}
	
	public static String getKey(int value) {
		for(TypeEnum t : TypeEnum.values()) {
			if(t.getValue()==value) {
				return t.desc;
			}
		}
		
		return null;
	}
	
	public int getValue() {
		return value;
	}

}
