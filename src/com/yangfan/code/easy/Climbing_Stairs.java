package com.yangfan.code.easy;
/************************************************
    * Description: 
    * You are climbing a stair case. It takes n steps to reach to the top.
	  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	  Note: Given n will be a positive integer. 
	  
	  tags: Dynamic Programming
    * 
    * 比如 3个台阶
    * 1 2和 2 1 是两种爬法   注意
    * 
    * realize the 
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年3月3日 上午10:14:07 
**************************************************/
public class Climbing_Stairs {
    public static void main(String[] args) {
//		timeTest();
		System.out.println(testCCC(4));
	}
    
    public static int climbStairs(int n){
    	if(n==1) return 1;
    	if(n==2) return 2;
    	int first =1;
    	int second =2;
    	int sum =0;
    	for(int i=2;i<n;i++){
    		sum = first + second;
    		first = second;
    		second = sum;
    	}
    	return sum;
    }
    public static int climbStairsR(int n) {
    	if(n==1||n==2)
    		return n;
    	else
    		return climbStairsR(n-1)+climbStairsR(n-2);
    }
    
    public static int testCCC(int n){
    	int x=1,y=1;
    	for(;n-->0;) {  //巧妙的用法  先判断了>0 然后n-- 无论是否大于0 n--都会执行
    		y=y+x;
    		x=y-x;
    	}
    	return x;
    }
    
    public static void timeTest(){
    	long start1 = System.currentTimeMillis();
    	System.out.println(climbStairs(44));
    	long end1 = System.currentTimeMillis();
    	System.out.println("非递归执行时间是："+(end1-start1));
    	long start = System.currentTimeMillis();
    	System.out.println(climbStairsR(44));
    	long end = System.currentTimeMillis();
    	System.out.println("递归执行时间是："+(end-start));
    }
}
