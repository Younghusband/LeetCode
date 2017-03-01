package com.yangfan.code;
/************************************************
    * Description: 
    *    Given a non-negative integer represented as a non-empty array of digits
    *    , plus one to the integer.

         You may assume the integer do not contain any leading zero
         , except the number 0 itself.

         The digits are stored such that the most significant digit is at the head of the list.
    *    
    *    题目大意

　　                  给定一个用数组表示的一个数，对它进行加一操作。
　　                  每一个数位都存储在数组的一个位置上。数组下标从小到大表示数位的高位到低位（这样看起来比较直观）。 
    * 
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年3月1日 下午12:15:20 
**************************************************/
public class Plus_One {
	
        public static void main(String[] args) {
			int x = 32340531;
			int [] arr = integer2intArr(x);
			print(arr); 
			//以上提供了测试数据
			System.out.println("-------加1后------");
			plusOne(arr);
			print(arr);
		}
        
        
        /**
         * 将integer 转换成这样的数组  就不存在这越界问题  只存在进位问题  
         * 一个天才的想法
         * 
         * 极端情况  99999  这样数组会越界
         * @param digits
         * @return
         */
        public static int[] plusOne(int[] digits) {
        	int carry =1;   //改成别的值 方法就变成plusN了 比较灵活
        	for(int i=digits.length-1;i>=0;i--){
        		int result = digits[i]+carry;
        		digits[i]=result%10; 
        		carry = result/10;
        		if(carry==0){
        			break;
        		}
        	}
        	if(carry==1){   //处理99999...的问题   能走到这一步 此时的数组全部都是0了
        		int [] temp = new int [digits.length+1];
        		System.arraycopy(digits, 0, temp, 1, digits.length);   //这是个void 函数
        		temp[0] = carry;  //10000... 功德圆满
        		return temp;
        	}
            return digits;
        }
        
        
        /**
         * 别人更为简洁的方法
         * 聪明就聪明在  new int [x]  默认数组元素全为0 这一点！！！
         */
        public static int[] plusOnePro(int[] digits) {
        	 int n = digits.length;
        	    for(int i=n-1; i>=0; i--) {
        	        if(digits[i] < 9) {
        	            digits[i]++;
        	            return digits;
        	        }
        	        digits[i] = 0;
        	    }
        	    int[] newNumber = new int [n+1];
        	    newNumber[0] = 1;
        	    return newNumber;   //By default java will initialize the whole array as 0. If we come to this stage of the code,
        }
        
        
        /**
         * 辅助工具类  帮助将该integer 转换为int [] 
         * @param x
         * @return
         */
        public static int [] integer2intArr(int x){
        	int store = x;
        	int size = 0;
        	while(store!=0){
        		store=store/10;
        		size++;
        	}
        	int [] arr = new int [size];
        	for(int i=size-1;i>=0;i--){
        		arr[i] = x%10;
        		x/=10;
        	}
        	return arr;
        }
        
        public static void print(int [] arr){
        	for(int temp : arr)
				System.out.print(temp+"->");
        	System.out.println();
        }
}
