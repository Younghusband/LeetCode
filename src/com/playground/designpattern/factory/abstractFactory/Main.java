package com.playground.designpattern.factory.abstractFactory;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年3月22日 上午10:00:30
 * 
 * 抽象工厂
 * 
 */

public class Main {
	
	public static void main(String[] args) {
		AbsFactory a1 = new LanzhouFactory();
		AbsFactory a2 = new MacFactory();
		
		IFood food1 = a1.provideFood();
		IDrink drink1 = a1.provideDrink();
		
		IFood food2 = a2.provideFood();
		IDrink drink2 = a2.provideDrink();
		
		
		food1.eat();
		drink1.drink();
		
		System.out.println("---------------------------");
		
		food2.eat();
		drink2.drink();
	}

}
