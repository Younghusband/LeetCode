package com.yangfan.test;
/************************************************
    * Description: 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年2月24日 上午10:22:57 
**************************************************/
public class TestRemove_Du {
     public static void main(String[] args) {
//    	 int [] arr = {-3,-1,0,0,0,3,3};   //应该返回5
    	 int [] arr = {};
		  int lenBack = removeDuplicates(arr);
		  System.out.println(lenBack);
		  for(int i=0;i<lenBack;i++){
			  System.out.print(arr[i]+" ");
		  }
	}

	private static int removeDuplicates(int[] arr) {
		int i =arr.length==0?0:1;
		for( int n :arr){
			System.out.println("进入for.....");
			if(n>arr[i-1])  {
				arr[i++] = n;
			}
		}
		return i;
	}
     
     
}
