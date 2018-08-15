package com.problems.test;
/************************************************
    * Description: 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年4月5日 下午1:59:33 
**************************************************/
public class TestString {
      public static void main(String[] args) {
//    	  print10();
		print11(10);
	}
      
      
      public static void print10(){
    	  for(int i=0;i<10;i++){
    		  System.out.println(i);
    	  }
      }
      
      public static void print11(int n){
    	 if(n>0){
    		 print11(n-1);
    		 System.out.println(n);
    	 }
      }
}
