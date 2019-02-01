package com.problems.code.easy;

/**
 * @author mr_yo
 * 
 * 巴什博奕，n%(m+1)!=0时，先手总是会赢的
 */
public class Nim_Game {
    
    
    public boolean canWinNim(int n) {
        return n%4!=0;
    }
    
}
