package com.yangfan.code.easy;
/************************************************
 * Description: 
 *    Determine whether an integer is a palindrome. Do this without extra space.
 *    
 * @author    Vermouth.yf  
 * @version  1.0
 * @date ：2017年1月20日 下午2:00:50 
**************************************************/
public class Palindrome_Number {
    public static void main(String[] args) {
   	 Palindrome_Number pn = new Palindrome_Number();
		 System.out.println(pn.isPalindrome(1234321));   //true
		 System.out.println(pn.isPalindrome(1));     //true
		 System.out.println(pn.isPalindrome(123));   //false
	}
    
    public boolean isPalindrome(int x) {
   	 boolean flag = false;
   	 if(x<0) return flag;   //can negative numbers be palindrome?
   	 int rev = 0,y=x; //y use for generate backward number
   	 while(y!=0){
   	    rev = rev*10+y%10;	 
   		if(rev>Integer.MAX_VALUE){
   			return flag;
   		}
   		y = y/10;
   	 }
   	 flag=(rev==x);  
        return flag;
    } 
    
}
