package com.problems.code.easy;
/************************************************
    * Description: 
    *    Implement atoi to convert a string to an integer.
    *    
    *    atoi( ) 函数会扫描参数 nptr字符串，跳过前面的空白字符（例如空格，tab缩进等，可以通过isspace( )函数来检测），
    *    直到遇上数字或正负符号才开始做转换，而再遇到非数字或字符串结束时('\0')才结束转换，并将结果返回。
    *    如果 nptr不能转换成 int 或者 nptr为空字符串，那么将返回 0[1]。
    *    
    *    这道题能够获得的知识        
    *    1. str.charAt(index)-'0'  通过这个值来判断是否为数字字符 和 获取数字字符的int值
    *    2. Character.isDigit(char x)  
    *    
    *    这题不是什么有趣的题目，并不需要什么Top Solutions
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年1月20日 下午12:03:12 
**************************************************/
public class String_to_Integer_atoi {
	
	 public static void main(String[] args) {
		 String_to_Integer_atoi s = new String_to_Integer_atoi();
		 System.out.println(s.myAtoi("-1342da "));
	}
	
      public int myAtoi(String str) {
    	  if(str==null || str.length()==0){
    		  return 0;
    	  }
    	  str = str.trim();
    	  int index = 0,sign = 1;
    	  long sum=0;    //return sum*sign
    	  // judge the sign
          if(str.charAt(index)=='+'||str.charAt(index)=='-'){
        	   sign=str.charAt(index)=='+'?1:-1;   
        	   index++;    //只有属于'+' '-'才能驱动index++
           }
    	  //enter the main operation
          while(index<str.length()){
        	  int x = str.charAt(index++)-'0';
        	  if(x<0||x>9) return (int)sum*sign;
        	  sum = sum*10+x;
        	  if(sum>Integer.MAX_VALUE){
        		  return  sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
        	  }
          }
    	  
    	 return (int)sum*sign;   //转换的是sum  而非sum*sign
    }
}
