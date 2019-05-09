package com.playground.designpattern.observer;

/**
 * @author mr_yo
 * 
 * test 
 */
public class Main {
    
    public static void main(String[] args) {
        BeWatched sb = new BeWatched();
        BeWatched sb1 = new BeWatched();
        BinaryObserver bo = new BinaryObserver(sb);
        HexaObserver he = new HexaObserver(sb);
        OctalObserver oc = new OctalObserver(sb1);
        
        sb.setState(100);
        
        sb.setState(9999);
        
        sb1.setState(100);
        
    }
}
