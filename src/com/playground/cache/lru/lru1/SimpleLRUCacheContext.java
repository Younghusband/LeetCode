package com.playground.cache.lru.lru1;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;

/**
 * @author: Vermouth
 * @create: 2021-06-17 11:35
 * @description:  朴素LRU缓存数据模型
 **/

@Data
@NoArgsConstructor
public class SimpleLRUCacheContext<K, V> {

    /**
     * 缓存池大小
     */
    protected int cacheCapacity;

    protected LinkedHashMap<K, V> data;

    public SimpleLRUCacheContext(int capacity) {
        this.cacheCapacity = capacity;
        data = Maps.newLinkedHashMap();
    }





}
