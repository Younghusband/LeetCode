package com.playground.testenum;

public enum Type {
    
    A, B{
        public String getType() {
            return "i will tell you";
        }
    };
    
    static int value;
    public static int getValue() {
        return value;
    }
    
    
    String type;
    public String getType() {
        return type;
    }
    

}
