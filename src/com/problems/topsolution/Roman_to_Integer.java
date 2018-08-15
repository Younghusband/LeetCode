package com.problems.topsolution;
/************************************************
    * Description: 
    *   
    *   这个top solution 其实不咋滴
    *   但是有一点需要注意的是:
    *   ""IV"is 4 if it exists more than once, is 8 should be "VIII" but no two "IV"
         "IX"is 9 if it exists more than once, is 18 should be "XVIII" but no two"IX"
         "IV"is 40 if it exists more than once, is 80 should be "LXXX" but no two "IV""
         
                    那些减法的组合每一种只会出现一次...   所以才会出现如下的解法
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年1月24日 下午4:39:40 
**************************************************/
public class Roman_to_Integer {
	public int romanToInt(String s) {
	     int sum=0;
	    if(s.indexOf("IV")!=-1){sum-=2;}   //each situation below happen once 
	    if(s.indexOf("IX")!=-1){sum-=2;}
	    if(s.indexOf("XL")!=-1){sum-=20;}
	    if(s.indexOf("XC")!=-1){sum-=20;}
	    if(s.indexOf("CD")!=-1){sum-=200;}
	    if(s.indexOf("CM")!=-1){sum-=200;}
	    
	    char c[]=s.toCharArray();
	    int count=0;
	   for(;count<=s.length()-1;count++){
	       if(c[count]=='M') sum+=1000;
	       if(c[count]=='D') sum+=500;
	       if(c[count]=='C') sum+=100;
	       if(c[count]=='L') sum+=50;
	       if(c[count]=='X') sum+=10;
	       if(c[count]=='V') sum+=5;
	       if(c[count]=='I') sum+=1;
	   }
	   return sum;
	}
}
