package com.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年2月27日 下午2:56:27
 * 
 * 把形如 apple banana ca反转为ca banana apple
 * 
 * 要点1  首位不含空格，单词中间有若干个空格。
 * 要点2  反转字符串单词间隔的空格数要正确
 * 
 */

public class WordListReverse {
	
	public String reverse(String src) {
		//存储单词，并根据split长度建立空格数组
		String [] wordsArr = src.split("\\s+");
		String [] spaceArr = new String[wordsArr.length];//设置一个下标为0不存值的等长space数组
		int j =-1; //供spaceArr内部计数
		int spaceCount =0;
		boolean isFirstChar = true;
		for(int i=0;i<src.length();i++){
			char c = ' ';
			if(src.charAt(i)!=c){
				if(isFirstChar){
				   spaceArr[++j]=genSpaceStr(spaceCount);
				   spaceCount = 0;  //每次遇到单词，空格计数归零
				   isFirstChar = false;
				}
			}else{ //遇到空格了
				isFirstChar = true;
				spaceCount++;
			}
		}  //灌溉完spaceArr数组
		
		StringBuilder sb = new StringBuilder();
		for(int x=wordsArr.length-1;x>=0;x--){
			sb.append(wordsArr[x]).append(spaceArr[x]);
		}
        return sb.toString();
	}
	
	//空格字符串组装器
	public String genSpaceStr(int n){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++)
			sb.append(" ");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		WordListReverse reverse = new WordListReverse();
//		Scanner scan = new Scanner(System.in);
//		String src = scan.nextLine();
        BufferedReader br = null;
		String src = "";
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			src = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		String result=reverse.reverse(src);
		System.out.println(result);
	}
}
