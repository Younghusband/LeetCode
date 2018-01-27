package com.problems.code.easy;
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
	private static int NUM = 9999999;
	
    public static void main(String[] args) {
//    	System.out.println(Integer.MAX_VALUE);
//		System.out.println(mySqrtNewton(9000000));
//    	System.out.println(mySqrtBinarySearch(25));
		System.out.println("-------------测试暴力开方------------");
		runBruteForce();
		System.out.println("-------------测试牛顿开方------------");
		runNewton();
		System.out.println("-------------测试二分开方------------");
		runNewton();
		
	}
    
    
    /**
     * binarySearch method
     * 
     * 如果 x<n^2 && x>(n-1)^2  return n-1
     */
    public static int mySqrtBinarySearch(int x) {
    	if(x==0) return 0;    //不然会报分母为0的错误
    	int min=1,max=x;   //起始从1开始 而非0
    	while(true){
    		int mid = min+(max-min)/2;  //It's to prevent potential integer overflow instead of "(min+max)/2"
    		if(mid>x/mid){
    			max = mid -1;
    		}else{  //mid<=x/mid
    			if((mid+1)>x/(mid+1))
    				return mid;
    		    min = mid +1;
    		}
    	}
    }
    
    
    /**
     * newton method
     */
    public static int mySqrtNewton(int x) {
    	long i= x;   //careful with int
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
    
    public static void runBinary(){
    	long start = System.currentTimeMillis();
    	for(int i=1;i<=NUM;i++)
   	       mySqrtBinarySearch(i);
    	long end = System.currentTimeMillis();
    	System.out.println("二分法耗时："+(end-start)+"ms");
    }
    
    
}
