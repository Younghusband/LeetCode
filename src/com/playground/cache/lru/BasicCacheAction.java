package com.playground.cache.lru;

import com.playground.cache.lru.lru1.SimpleLRUCacheContext;

import java.util.LinkedHashMap;
import java.util.Stack;

public abstract class BasicCacheAction<K, V> {

    /**
     * 动作1, 缓存查询
     */
    public abstract V get(K k);

    /**
     * 动作2, 缓存放入
     */
    public abstract void put(K k, V v);


    /**
     * 移除队尾元素, 受限于缓存存储数据结构交由具体子类实现
     */
    public abstract void removeTailItem();

    /**
     * 内部动作: 缓存淘汰(队尾移除)
     */
    public boolean evict(SimpleLRUCacheContext cache) {
        boolean result = false;
        int currentSize = cache.getData().size();
        int cacheCapacity = cache.getCacheCapacity();
        if(currentSize >= cacheCapacity) {
            removeTailItem();
            result = true;
        }
        return result;
    }

    /**
     * 内部动作: 缓存更新(旧值移至队首)
     */
    public void update(K k, V v, SimpleLRUCacheContext cache) {
        // 1. remove old val
        cache.getData().remove(k);

        // 2. insert new val to first pos
//        cache.getData().add(assembleItem(k, v));
        cache.getData().put(k, v);
    }

    public void printMyself(SimpleLRUCacheContext cache) {
        LinkedHashMap<K, V> data = cache.getData();
        if(data == null || data.size() <= 0) {
            return;
        }
        Stack<String> msg = new Stack<>();
        data.entrySet().forEach(
            s -> {
                StringBuilder sb = new StringBuilder();
                sb.append("[Key=");
                sb.append(s.getKey()+", Value=");
                sb.append(s.getValue()+"]");

                msg.push(sb.toString());
            }
        );
        int originSize = msg.size();
        for(int i =0; i < originSize; i++) {
            System.out.println(msg.pop());
        }
    }

}
