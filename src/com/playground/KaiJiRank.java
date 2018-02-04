package com.playground;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @description
 * @author vermouth.Mac
 * @version 2018年2月4日 下午9:07:36
 * 
 *          源于和搜狐视频的面试。当时答的不好，在这里实施一遍。 如何通过输入一个开机时间，来确定你击败了全国百分之多少的用户。
 * 
 *          此版本的程序缺陷在于，程序关闭后数据就清0了。
 * 
 *          两个注意点
 *           1. 开机超越 = （比我慢的所有人/总人数)*100% 那么问题就来了，第一个key值的所有人都是超越了0%
 *              这个符合逻辑么 
 *          2. (double)5/10 这样才能得到0.5
 * 
 *          3. 解决措施是，当key的种类为一的时候，不按算法来 return 100%
 */

public class KaiJiRank {

	private static int sum = 0;
	private static int keyCount = 0;
	private static HashMap<Integer, Integer> tree = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String val = "";
			while (true) {
				System.out.println("请输入您的开机时间:\t");
				val = br.readLine();
				if (val.equals("bye"))
					break;
				else if (val.equals("")) {
					System.out.println("输入为空，请重新输入");
					continue;
				}
				System.out.println("您的开机时间是:\t" + val);
				double rate = 0;
				rate = getRate(processString2Int(val));
				String result = String.format("%.2f", rate);
				System.out.println("您的开机速度击败了全国 " + result + "%的用户。");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				br = null;
			}
		}
	}

	/**
	 * 0. 设置key=0 ,记录总人数。 每次开机都++ int sum 1. 根据key getValue 该key的count++ 2. 遍历全部
	 * key > m 的所有count值。v 3. 开机超越比例为 v/sum *100 返回
	 **/

	public static double getRate(int m) {
		int outer = 0; // 落后的人
		double rate = 0;
		sum++; // 0. 总数加一
		if (tree.containsKey(m)) {
			tree.put(m, tree.get(m) + 1);
		} else {
			tree.put(m, 1);
			keyCount++;
		}
		
		if (keyCount>1) {
			Iterator<Map.Entry<Integer, Integer>> it = tree.entrySet().iterator();
			w: while (it.hasNext()) {
				Map.Entry<Integer, Integer> map = it.next();
				Integer key = map.getKey();
				Integer count = map.getValue();
				if (key <= m) {
					continue w;
				} else {
					outer += count;
				}
			}
			rate = 100 * ((double) outer / sum);
			return rate;
		}else
			return 100;

	}

	/***
	 * 专注于处理输入的字符串转为int的操作。 11.5 -> 11
	 * 
	 * @param raw
	 * @return
	 */
	public static int processString2Int(String raw) {
		Double d = Math.floor(Double.valueOf(raw));
		int result = d.intValue();
		return result;
	}

}
