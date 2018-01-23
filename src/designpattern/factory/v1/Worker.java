package designpattern.factory.v1;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月22日 下午6:01:00
 */

public class Worker implements People {

	@Override
	public void produce() {
        System.out.println("我是工人，我每天都要搬砖");
	}

}
