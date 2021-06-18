package com.playground.cache.lru.lruk;

import com.google.common.collect.Maps;
import com.playground.cache.lru.lru1.SimpleLRUCacheContext;
import lombok.Data;

import java.util.Map;

/**
 * @author: Vermouth
 * @create: 2021-06-17 11:35
 * @description:  LRU-K缓存数据模型
 **/

@Data
public class PremiumLRUCacheContext<K, V> extends SimpleLRUCacheContext<K, V> {
    /**
     * LRU-K的那个K的值
     */
    private int threshold;
    /**
     * 队列默认长度上限
     */
    private int queueCapacity;

    private Map<K, Integer> FIFOCountQueue;

    private static final int DEFAULT_THRESHOLD = 2;

    public PremiumLRUCacheContext(int capacity, int queueCapacity) {
        this.threshold = DEFAULT_THRESHOLD;
        this.cacheCapacity = capacity;
        this.queueCapacity = queueCapacity;
        this.data = Maps.newLinkedHashMap();
        this.FIFOCountQueue = Maps.newLinkedHashMap();
    }

    public PremiumLRUCacheContext(int capacity, int queueCapacity, int k) {
        this.cacheCapacity = capacity;
        this.queueCapacity = queueCapacity;
        this.data = Maps.newLinkedHashMap();
        this.FIFOCountQueue = Maps.newLinkedHashMap();
        this.threshold = k;
    }



}
