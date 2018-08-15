package com.problems.code.easy;

import java.util.Random;

/************************************************
    * Description: 
    *     做这题之前首先要理解 zigzag到底是什么形式的  不仅仅是局限于例子中的3行
    *     4行的时候
		   line1      1    7    D    
		   line2      2  6 8  C E  
		   line3      3 5  9 B  F 
		   line4      4    A       
    *      0 1 2 3 2 1 0 
    *      
    *      思路 
    * @author    杨帆  
    * @version  1.0
    * @date ：2017年1月19日 下午3:13:46 
**************************************************/
public class ZigZag_Conversion {
	
	public static void main(String[] args) {
		ZigZag_Conversion zig = new ZigZag_Conversion();
//		String before =zig.generatorABC(50);
		System.out.println("转换前："+"ABCDEFG");
		String after=zig.convert("ABCDEFG", 4);
		System.out.println("转换后："+after);
	}
	
    /**
     * Description:
     *    
     * 
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
    	if(numRows==1){
    		return s;     // corner case!
    	}
    	char[] strArr = s.toCharArray();
    	char[] strResult = new char[strArr.length];  //存储排序后的char[]
    	boolean direct =true;  //true代表从1到4 false 代表从4到1
        int len = strArr.length;
        int j = 1,i = 0;
        int [] intArr = new int[len];
        while(len>0){
        	intArr[i]=j;
        	if(j==numRows) //到峰值回转
        		direct = false;
        	if(j==1)
        		direct = true; //到谷值回转
        	j=(direct)?j+1:j-1;   // 看看这样使用三目运算符对不对
        	len--;
        	i++;
        }
        int index = 0;
        for(int line=1;line<=numRows;line++){
        	for(int xx=0;xx<strArr.length;xx++){
        		if(intArr[xx]==line){
        			strResult[index++]=strArr[xx];
        		}
        	}
        }
    	return new String(strResult);
    }
    
    /**
     * not
     * 
     */
    public String generatorABC(int n){
    	char [] store = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','?'};
    	Random ran = new Random();  //不要带构造
    	int count = n;
    	StringBuffer sb = new StringBuffer();
    	while(count>0){
    		sb.append(store[ran.nextInt(store.length)]);
    		count--;
    	}
    	
    	return sb.toString();
    }

}
