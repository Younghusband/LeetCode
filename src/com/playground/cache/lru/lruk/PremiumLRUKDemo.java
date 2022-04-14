package com.playground.cache.lru.lruk;

import com.playground.cache.lru.BasicCacheAction;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Vermouth
 * @create: 2021-06-17 15:19
 * @description:
 * 与LRU-1区别在于
 * 1. 维护了一个历史访问队列
 * 2. 缓存访问涉及历史队列到正式缓存的晋升(promotion)过程
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PremiumLRUKDemo<K, V> extends BasicCacheAction<K, V> {

    private PremiumLRUCacheContext cache;

    public PremiumLRUKDemo() {
        this.cache = new PremiumLRUCacheContext(4, 8);
//        this.cache = new PremiumLRUCacheContext(4, 8, 1);
    }

    /**
     * 有一点疑问:
     * 历史队列只存储k, 以及k被访问的频次。
     * 理论上一个k不应该也不可能同时存在于历史队列和缓存队列中
     * 所以我的做法是如果有一个k不存在于缓存队列里，
     * 如果不停的get它而不put，那么仅仅只会增长其历史队列的计数而无视threshold。
     * 只需要put一次立刻晋升到缓存队列
     */
    public V get(K k) {
        LinkedHashMap<K, V> data =  this.cache.getData();
        // 1. 缓存命中
        if(data.containsKey(k)) {
            V v = data.get(k);
            update(k, v, this.cache);
            return v;
        }
        // 2. 缓存穿透
        updateFIFOCountQueue(k);
        return null;
    }

    @Override
    public void put(K k, V v) {
        LinkedHashMap<K, V> data = this.cache.getData();
        // 1. 缓存命中
        if(data.containsKey(k)) {
            update(k, v, this.cache);
        }
        // 2. 缓存穿透
        else {
            // 2.1 是否晋升
            if(promote(k)) {
                // 2.1.1 执行淘汰
                evict(this.cache);
                data.put(k, v);
            }
        }
    }

    @Override
    public void removeTailItem() {
        LinkedHashMap<K, V> data = this.cache.getData();
        if(data == null || data.size() <= 0) {
            return;
        }
        K k = (K)data.keySet().toArray()[0]; // 队尾元素即为map头元素
        data.remove(k);
    }

    /**
     * 值从queue 到 cache的晋升
     * 同时管理fifo的值更替
     */
    public boolean promote(K k) {
        K removeByQueue = updateFIFOCountQueue(k);
        return k.equals(removeByQueue);
    }

    /**
     * 对历史队列进入新值时的操作
     */
    public K updateFIFOCountQueue(K k) {
        /**
         * 访问队列相关数值
         */
        Map<K, Integer> fifoQ = this.cache.getFIFOCountQueue();
        int threshold = this.cache.getThreshold();
        int qCapacity = this.cache.getQueueCapacity();
        int qCurrentSize = fifoQ.size();
        Integer count = fifoQ.get(k) == null ? 0 : fifoQ.get(k);

        /**
         * 最终从访问队列移除的元素
         * 可能为null, 可能为k, 可能为其他被淘汰值
         */
        K popK = null;
        // 1. fifo队列中
        if(fifoQ.containsKey(k)) {
            if(++count >= threshold) {
                popK = k;
                fifoQ.remove(k); // 达到阈值后退出队列
            } else {
                fifoQ.put(k, count); // 重新把+1后的值放入队首
            }
        }
        // 2. 需新加入队列
        else {
            // 极端情况，k=1时
            if(++count >= threshold) {
                popK = k;
            } else {
                fifoQ.put(k, count);
                // 队列已满
                if(qCurrentSize >= qCapacity) {
                    // 将队列最末元素移除
                    K oldestKey = (K)fifoQ.keySet().toArray()[qCurrentSize-1];
                    popK = oldestKey;
                    fifoQ.remove(oldestKey);
                }
            }
        }
        return popK;
    }


    public static void main(String[] args) {
        PremiumLRUKDemo<String, Integer> demo = new PremiumLRUKDemo<>();
//        demo.put("One", 1);  // 屏蔽可以测试get的逻辑
        demo.put("Two", 2);
        demo.put("Three", 3);
        demo.put("Four", 4);

        demo.put("Two", 3);
        demo.get("One");
        demo.put("One", 2);

        demo.printMyself(demo.getCache());
    }


}
