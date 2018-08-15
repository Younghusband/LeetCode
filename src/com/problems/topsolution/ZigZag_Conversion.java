package com.problems.topsolution;


/************************************************
    * Description: 
    *    Create nRows StringBuffers, and keep collecting characters 
    *    from original string to corresponding StringBuffer. 
    *    Just take care of your index to keep them in bound.
    *  
    * @author    杨帆  
    * @version  1.0
    * @date ：2017年1月20日 上午10:51:28 
**************************************************/
public class ZigZag_Conversion {
     public static void main(String[] args) {
    	 ZigZag_Conversion zig = new ZigZag_Conversion();
// 		String before =zig.generatorABC(50);
 		System.out.println("转换前："+"ABCDEFGHIJKLMN");
 		String after=zig.convert("ABCDEFGHIJKLMN", 3);
 		System.out.println("转换后："+after);
		
	}
     
     public String convert(String s, int nRows) {
    	 char [] src = s.toCharArray();
    	 StringBuffer [] sb = new StringBuffer[nRows];  //to get why this pot not need()
    	 for(int i=0;i<nRows;i++) sb[i]=new StringBuffer();
    	 int index =0;
    	 while(index<src.length){
    		 for(int i=0;i<nRows&&index<src.length;i++){  //the key point is "&&index<src.length"
    			 sb[i].append(src[index++]);
    		 }
    		 for(int i=nRows-2;i>=1&&index<src.length;i--){
    			 sb[i].append(src[index++]);
    		 }
    	 }
    	 for(int i=1;i<nRows;i++) sb[0].append(sb[i]);
    	 return sb[0].toString();
    	}
}
