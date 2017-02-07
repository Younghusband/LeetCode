package com.yangfan.repository;
/************************************************
    * Description: 
    *    关于this关键字的应用
    * @author    杨帆  
    * @version  1.0
    * @date ：2017年1月13日 上午11:47:00 
**************************************************/
public class TestThis {
	  int count;
      TestThis increment(){
    	  count++;
    	  return this;
      }
      
      public void print(){
    	  System.out.println("count="+count);
      }
      
      public static void main(String[]args){
    	  TestThis this1 = new TestThis();
    	  this1.increment().increment().increment().print();
      }
}
