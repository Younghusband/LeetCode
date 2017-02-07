package com.yangfan.code;

import java.util.Arrays;

/************************************************
    * Description:   var Question : LeetCode 
    *   
    *   Reverse digits of an integer.
    *   Example1: x = 123, return 321
    *   Example2: x = -123, return -321 
    * 
    *   不要小瞧  有着复杂的逻辑处理
    *   从最初的script到最后调整完毕的代码，收获很多
    *   首先input的int值不能越界（这个与我的程序无关，输入方自己需注意）
    *   进入方法后判断各种奇葩情况，在排序组合完的new Integer情况下注意把异常抛出
    *   在总方法中catch异常，并做处理
    *   
    *   点评：  那个try catch是点睛之笔
    *   
    * @author    杨帆  
    * @version  1.0
    * @date ：2017年1月17日 上午9:46:06 
**************************************************/
public class Reverse_Integer {
	
	 public static void main(String[] args) {
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		System.out.println(max+"||"+min);
		
		int x = 10000;
		
		System.out.println(new Reverse_Integer().proReverse(x));
		
		int var = 2147483647+2;
		System.out.println(var);
	}
	
     public int reverse(int x) {
    	 if(x>Integer.MAX_VALUE||x<Integer.MIN_VALUE){
    		 return 0;
    	 }  //反转后的也要来次判断
    	 int result = 0;
    	 try{
         if(x==0){
        	 return x;
         }else if(x<0){
        	 result = reversePassive(x);
         }else
        	 result = reversePositive(x);
    	 }catch(Exception e){
    		 return 0;
    	 }
         if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE){
        	 return 0;
         }
         return result;
    }
     
     public int reversePassive(int x) throws Exception{
    	 int result = 0;
    	 String tempStr = String.valueOf(x);
         char [] tempArr = tempStr.toCharArray();
         char [] store = null ;
    	 for(int i=0;i<tempArr.length;i++){
        	 if(tempArr[i]=='-'){
        		 store = new char[tempArr.length-1];
        		 continue;
        	 }
        	 store[store.length-i]=tempArr[i];
         }
    	 try{      
           result = Integer.valueOf(new String(store));
    	 }catch(Exception e){
    		 throw e;
    	 }
          return -result;
     }
     
     public int reversePositive(int x) throws Exception{
    	 int result = 0;
    	 String tempStr = String.valueOf(x);
         char [] tempArr = tempStr.toCharArray();
         char [] store = new char[tempArr.length] ;
    	 for(int i=0;i<tempArr.length;i++){
        	 store[store.length-1-i]=tempArr[i];
         }
    	 try{
           result = Integer.valueOf(new String(store));
    	 }catch (Exception e){
    		 throw e;
    	 }
          return result;
     }
     
     /**
     * from LeetCode Top Solution
     * "Only 15 lines.
        If overflow exists, the new result will not equal previous one.
        No flags needed. No hard code like 0xf7777777 needed."
     */
    public int proReverse(int x){
    	 int result = 0;
    	    while (x != 0)    //假设输入1234
    	    {
    	        int tail = x % 10;    //取到数字末尾4,3,2,1
    	        int newResult = result * 10 + tail;  //4,43,432,4321
    	        if ((newResult-tail)/10!=result) //如果newResult超限 会变成负的
    	        { return 0; }
    	        result = newResult;   //4,43,432,4321
    	        x = x / 10;           //123,12,1,0 --> return
    	    }
    	    return result;
     }
    
    public int theBestSolution(int ready){
    	 long  dev = 0;
		  while(ready!=0){
			   dev = dev*10+ready%10;
			   ready = ready/10;
			   if(dev>Integer.MAX_VALUE||dev<Integer.MIN_VALUE){
				   return 0;
			   }
		  }
		  return (int)dev;
    }
    
}
