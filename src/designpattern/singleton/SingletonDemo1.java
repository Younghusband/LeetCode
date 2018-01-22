package designpattern.singleton;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月21日 下午5:26:37
 * 
 * 
 *  懒汉式 线程不安全写法
 *  
 *  这种写法lazy loading很明显，但是致命的是在多线程不能正常工作。　
 */


public class SingletonDemo1 {
	private static SingletonDemo1 instance;
	private SingletonDemo1(){};
	
	public static SingletonDemo1 getInstance(){
        if(instance==null){
        	instance = new SingletonDemo1();
        }
		return instance;
	}

}
