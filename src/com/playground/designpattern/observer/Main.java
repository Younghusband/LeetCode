package com.playground.designpattern.observer;

/**
 * @author mr_yo
 * 
 * test 
 */
public class Main {
    
    public static void main(String[] args) {
        Subject sb = new Subject();
        BinaryObserver bo = new BinaryObserver(sb);
        HexaObserver he = new HexaObserver(sb);
        OctalObserver oc = new OctalObserver(sb);
        
        sb.setState(100);
        
        sb.setState(9999);
        
    }
}
