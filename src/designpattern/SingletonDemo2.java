package designpattern;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月21日 下午7:33:40
 * 
 * 懒汉式  线程安全
 * 
 * 阻塞过于严重  大多数情况下并不需要同步
 */

public class SingletonDemo2 {
	private static SingletonDemo2 instance;
	private SingletonDemo2(){}
	
	public static synchronized SingletonDemo2 getInstance(){
        if(instance==null){
        	instance = new SingletonDemo2();
        }
		return instance;
	}

}
