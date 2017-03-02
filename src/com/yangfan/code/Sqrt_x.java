package com.yangfan.code;
/************************************************
    * Description: 
    * Implement int sqrt(int x).
    * Compute and return the square root of x.
    * 
    * 并没有什么思路，尝试Brute-Force
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年3月2日 下午4:34:06 
**************************************************/
public class Sqrt_x {
	private static int NUM = 2222222;
	
    public static void main(String[] args) {
//    	System.out.println(Integer.MAX_VALUE);
//		System.out.println(mySqrtNewton(9000000));
		System.out.println("-------------测试暴力开方------------");
		runBruteForce();
		System.out.println("-------------测试牛顿开方------------");
		runNewton();
	}
    
    
    /**
     * newton method
     */
    public static int mySqrtNewton(int x) {
    	long i= x;
    	while(i*i>x)   //循环次数大大小于Brute-Force
    		i = (i+x/i)/2;
    	return (int)i;  
    }
    
    /**
     * 这种方法最慢，待开方数字越大  计算得出结果越慢
     */
    public static int mySqrtSlow(int x){
    	long i= 0;
    	int root=0;
    	while(i*i<=x){  //这里面有个陷阱 i*i一旦超过 int.max_value 就会出错
    		root = (int)i;
    		i++;
    	}
        return root;  
    }
    
    public static void runBruteForce(){
    	long start = System.currentTimeMillis();
    	for(int i=1;i<=NUM;i++)
    	     mySqrtSlow(i);
    	long end = System.currentTimeMillis();
    	System.out.println("暴力法耗时："+(end-start)+"ms");
    }
    
    public static void runNewton(){
    	long start = System.currentTimeMillis();
    	for(int i=1;i<=NUM;i++)
   	       mySqrtNewton(i);
    	long end = System.currentTimeMillis();
    	System.out.println("牛顿法耗时："+(end-start)+"ms");
    }
    
    
}
