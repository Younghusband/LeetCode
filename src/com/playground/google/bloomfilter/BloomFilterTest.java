package com.playground.google.bloomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterTest {

    private static int size = 1000000;

    private static BloomFilter<Integer> integerFilter = BloomFilter.create(Funnels.integerFunnel(), size);


    /**
     *  低精度 误报率默认3%
     */
    private static BloomFilter<CharSequence> stringFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), size);

    /**
     * 高精度 误报率0.02%
     */
    private static BloomFilter<CharSequence> highPrecisionStringFilter
            = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), size, 0.0002);

    public static void main(String[] args) {
        // initialize bloom filter
        for (int i = 0; i < size; i++) {
            integerFilter.put(i);
        }
        long startTime1 = System.nanoTime(); // 获取开始时间
        
        //判断这一百万个数中是否包含29999这个数
        if (integerFilter.mightContain(29999)) {
            System.out.println("命中了");
        }
        long endTime1 = System.nanoTime();   // 获取结束时间
        System.out.println("程序运行时间： " + (endTime1 - startTime1) + "纳秒");

        // 注入100W个值
        for(int i = 0; i < size; i++) {
            stringFilter.put(i+"");
            highPrecisionStringFilter.put(i + "");
        }

        int hit1 = 0;
        int hit2 = 0;
        // 查找注入的100W个值，以及以外的1W个值
        for(int i = 0; i < size + 10000; i++) {
            if(stringFilter.mightContain(i+"")){
                hit1 ++;
            }
            if(highPrecisionStringFilter.mightContain(i+"")){
                hit2 ++;
            }
        }

        System.out.printf("低精度Bloom Filter hit数 : %s\n", hit1);
        System.out.printf("高精度Bloom Filter hit数 : %s\n", hit2);

    }
    

}
