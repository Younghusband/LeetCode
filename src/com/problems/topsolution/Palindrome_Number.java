package com.problems.topsolution;
/************************************************
    * Description: 
    *   9-line accepted Java code, without the need of handling overflow
    *   compare half of the digits in x, so don't need to deal with overflow.
    *   
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年1月20日 下午3:04:40 
**************************************************/
public class Palindrome_Number {
	public boolean isPalindrome(int x) {
		if (x<0||(x!=0 && x%10==0)) return false;  //think this for what (x!=0&&x%10==0)
		int rev = 0;
		while(x>rev){
			rev = rev*10+x%10;
			x/=x;
		}
		return x==rev||x==rev/10;//x==rev is for the scenery of even digits, x==rev/10 for the odd digits.
		   
	}
}
