package com.problems.code.easy;
/************************************************
    * Description: 
    * 
    * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
    * return the length of last word in the string.

	  If the last word does not exist, return 0.

	  Note: A word is defined as a character sequence consists of non-space characters only.

      For example,
      Given s = "Hello World",
      return 5. 
    * 
    * 第一次遇到非空格启动计数

                 在计数内部遇到空格结束计数并跳出循环

	  java中 空白字符不能用 ' '  
	     只能用Character.isSpaceChar(char)  来判断
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年3月1日 上午11:35:12 
**************************************************/
public class Length_of_Last_Word {
      public static void main(String[] args) {
		String str = " sdfsf dDds dSd ssds ";
		System.out.println(str.trim().lastIndexOf('f'));
		System.out.println(lengthOfLastWord(str));
	}
      public static int lengthOfLastWord(String s) {
    	  char [] sArr = s.toCharArray();
    	  boolean flag = false;
    	  int count=0;
    	  for(int i=sArr.length-1;i>=0;i--){
    		  if(!Character.isSpaceChar(sArr[i]))  //遇到空格 x=1 遇到字符串 再遇到空格 x=2
    			               flag = true;
    		  if(flag){
    			  if(Character.isSpaceChar(sArr[i]))
    				  break;
    	          count++;
    		  }
    	  }
    	  return count;
      }
      
      /**
       * 偷懒的方法  利用trim 以及lastIndexOf
       * */
      public static int lengthOfLastWordPro(String s){
    	  return s.trim().length()-s.trim().lastIndexOf(" ")-1;
      }
}
