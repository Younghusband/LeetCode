package com.yangfan.code.easy;
/************************************************
    * Description: 
    * 
    *  Given two binary strings, return their sum (also a binary string).
		For example,
		a = "11"
		b = "1"
		Return "100". 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年3月1日 下午1:13:40 
**************************************************/
public class Add_Binary {
      public static void main(String[] args) {
    	  String s1 = "1011";
    	  String s2 = "11";   //结果是1+2+4=7  111
    	  System.out.println(addBinaryPro(s1,s2));
    	  //haha
 	}
      
      
    /**
     *  巧妙利用XOR
     */
    public static String addBinary(String a, String b) {
    	if(a.isEmpty()||a==null) return b;
     	if(b.isEmpty()||b==null) return a;
     	StringBuilder sb = new StringBuilder();
     	
     	int i=a.length()-1,j=b.length()-1;
     	int aByte,bByte;
     	int carry =0;
     	while(i>-1||j>-1||carry==1){   //循环条件  任一字符串没有走完  或者两个字符串都走完了  但是进一还在
     		aByte = (i>-1)?Character.getNumericValue(a.charAt(i--)):0;
     		bByte = (j>-1)?Character.getNumericValue(b.charAt(j--)):0;
     		int result = aByte^bByte^carry;  // core  位运算
     		carry = ((aByte+bByte+carry)>=2 )? 1 : 0;
     		sb.append(result);
     	}
         return sb.reverse().toString();	
      }
    
    
    
    /**
     * 更为巧妙的方法
     * 
     */
    public static String addBinaryPro(String a,String b){
    	StringBuilder sb = new StringBuilder();
    	int i = a.length()-1,j = b.length()-1,carry =0;
    	while(i>=0||j>=0){
    		int sum = carry;  //获取上一位操作进位值 1或0
    		if(i>=0) sum+= a.charAt(i--)-'0';
    		if(j>=0) sum+= b.charAt(j--)-'0';
    		sb.append(sum%2);  // 0 1 2 3 四种情况  该位只有0，1
    		carry = sum/2;  //2,3进位
    	}
    	if(carry==1) sb.append(carry);
    	return sb.reverse().toString();
    }
    
}
