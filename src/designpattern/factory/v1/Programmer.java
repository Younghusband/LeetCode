package designpattern.factory.v1;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月22日 下午6:01:37
 */

public class Programmer implements People {

	@Override
	public void produce() {
         System.out.println("我是工程师，我每天都要爆肝敲码!");
	}

}
