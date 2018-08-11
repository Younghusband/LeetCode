package com.playground;

import java.util.Arrays;
import java.util.function.Predicate;

import java.util.List;



/**
 * @author mr_yo
 *
 * test lambda
 */
public class Main {

	public static void main(String[] args) {
		
		new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
		
		
		List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		
		
	}
	
	
}
