package com.problems.code.easy;

import java.util.Stack;

/************************************************
    * Description: 
    *   
    *   Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
    *   determine if the input string is valid.

        The brackets must close in the correct order, 
        "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
        
                        这道题是经典啊。在此不剧透了...  思考的方向一开始正确了就好做了
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年2月3日 下午5:23:29 
**************************************************/
public class Valid_Parentheses {
	
	public static void main(String[] args) {
		 Valid_Parentheses valid = new Valid_Parentheses();
		 System.out.println("------------");
		 System.out.println(valid.isValid1("()"));
		 System.out.println("------------");
		 
	}
	
	//方法一
	public boolean isValid(String s) {
  	    Stack<Character> stack = new Stack<Character>();
  	    for(char c:s.toCharArray()){
  	    	if(c=='('){
  	    		stack.push(')');
  	    	}else if(c=='['){
  	    		stack.push(']');
  	    	}else if(c=='{'){
  	    		stack.push('}');
  	    	}else if(stack.isEmpty()||stack.pop()!=c){
  	    		return false;
  	    	}
  	    }
		return stack.isEmpty();
     }
	
	/**
	 * 1. s.isEmpty() 和 s.length()==0 
	 * 2. s.replace("xx","yy") 并不会改变原s
	 * 
	 * @param s
	 * @return
	 */
	public boolean isValid1(String s){
		int length = 0;
		do{
			length=s.length();
			s=s.replace("()", "").replace("[]", "").replace("{}", "");  //s.replace("","")
		}while(length!=s.length());
		return s.length()==0;
	}
	
	
       
}
