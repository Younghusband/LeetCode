package com.problems.code.easy;
/************************************************
    * Description: 
    *     Given a roman numeral, convert it to an integer.
    *     Input is guaranteed to be within the range from 1 to 3999.
    *     
    *     这道题的体会就是：
    *     不仅仅是学习了罗马数字的规则，而且更重要的意识到input的隐性规范要充分利用，并体现在函数中。
    *     错误的input是不行的。 比如   XCXC 完全可以作为 LXXX
    *     
    *     罗马数字规则：  
    *     
    *     1. 相同数字连写不超过三次
    *     2. 小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数    次数不限但不要违反条件1
             非常重要 3. 小的数字(仅限I、X和C)在大的数字的左边(只出现一次)，所表示的数等于大数减小数得到的数    
                                      并且这种XC的组合在整个罗马数字里只能出现一次。如果出现多次的话，说明该种组合可以被更优的方式替代。
          4. 在一个数上画横线 等于该数的千倍
    *     
    *     
    *     思路1：  将条件3的情况单独全部列出来，并做sum-=2倍该值 的操作
    *     思路2：  不必像思路1那么麻烦，因为规定了小的数字仅限IXC出现在大数的左侧，这属于小数出现在大数左侧的子集内。
    *           属于安全范围，直接用相邻比大小就行了，不必去判断小的是否为IXC
    *     
    *     于是我们采取了思路2.
    *    
    * @author    Vermouth.yf  
    * @version  1.0
    * @date ：2017年1月20日 下午3:39:23 
**************************************************/
public class Roman_to_Integer {
	
	public static void main(String[] args) {
		Roman_to_Integer t = new Roman_to_Integer();
		System.out.println(t.romanToInt("MCMXCVI"));
	}
	
    
    public int romanToInt(String s) {
        char [] strArr = s.toCharArray();
        int sum = getRoman(strArr[0]);
        for(int i = 0; i < strArr.length - 1; i++){  //len == 1?skip:
           if(getRoman(strArr[i]) < getRoman(strArr[i + 1])){
        	   sum = sum + getRoman(strArr[i + 1]) - 2 * getRoman(strArr[i]);
           }else
        	   sum += getRoman(strArr[i + 1]);
        }
    	return sum;
    }
	
    public int getRoman(char x){   //use for plus or minus
    	switch(x) {
    	case 'I': return 1;  
        case 'V': return 5;  
        case 'X': return 10;  
        case 'L': return 50;  
        case 'C': return 100;  
        case 'D': return 500;  
        case 'M': return 1000; 
        default : return -1;   //without this setting will reporting error message
    	}
    }
	
}
