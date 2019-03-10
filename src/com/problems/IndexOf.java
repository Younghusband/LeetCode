package com.problems;


/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月28日 下午7:54:01
 * 
 * ali面试 
 */

public class IndexOf {
    
	
	public static void main(String[] args) {
		 IndexOf m  = new IndexOf();
	     String str1 = "www.taobao.comwww.b";
	     String str4 = "oba";   //6   中间子串
	     String str2 = "com";   //11  结尾子串
	     String str3 = "cox" ;  //-1  不存在子串
	     String str5 = "www.taobao.coml";  //-1 超长子串
		 String str6 = "www.b";
	     
	     
	     System.out.println(m.getLocation(str1,str6));
	     System.out.println(str1.indexOf(str6));
	}
	
	
	public int getLocation(String src, String key) {
        if(key.length()>src.length()) return -1;
		int location = 0;
	    char [] srcArr = src.toCharArray();
	    char [] keyArr = key.toCharArray();
		for (int i = 0, j = 0; i < srcArr.length; i++) { // 只增src的下标
			if (keyArr[j] != srcArr[i]) {
				j = 0;
				continue;
			} else {
				j++;
			}
			if (j == keyArr.length) {  //这步一定要放在j++之后
				location = i-(keyArr.length-1);
				return location;
			}
		}
		return -1;
	}

}
