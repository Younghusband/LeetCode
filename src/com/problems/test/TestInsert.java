package com.problems.test;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2017年3月7日 下午8:54:58
 */

public class TestInsert {
      
	public static void main(String[] args) {
		int [] arr = {3,5,1,2,6,8};
//		int [] arr ={1};
		insertArr(arr);
		for(int temp : arr)
			System.out.print(temp+"->");
		
	}
	   public static void insertArr(int [] arr){
		   for(int i=1;i<arr.length;i++){
			   int temp = arr[i];
			   int j=i-1;
			   while(j>-1){
				   if(temp>=arr[j])
					   break;
				   arr[j+1] = arr[j];
				   arr[j--] = temp;
			   }
		   }
	   }
}
