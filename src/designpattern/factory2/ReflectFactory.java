package designpattern.factory2;

import designpattern.factory.v1.People;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月23日 上午1:53:31
 */

public class ReflectFactory {
	
	public static <E extends People> E zaoRen(Class<E> clz){
		E ren = null;
		try {
			ren = (E)Class.forName(clz.getName()).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ren;
	}
	

}
