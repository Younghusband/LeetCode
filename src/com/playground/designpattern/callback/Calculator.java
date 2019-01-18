package com.playground.designpattern.callback;

public class Calculator {
    
    public void call(DoJob customer, int ...addParams) {
        int result = add(addParams);
        customer.fillBlank(result, addParams);
    }
    
    public int add(int ...a) {
        int sum =0;
        for(int x : a) {
            sum+=x;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(new Calculator().add(1,2,3,4,5));
    }

}
