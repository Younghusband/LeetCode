package com.playground.cache.lru.lru1;

import com.playground.cache.lru.BasicCacheAction;
import lombok.Data;

import java.util.LinkedHashMap;

/**
 * @author: Vermouth
 * @create: 2021-06-17 11:30
 * @description: 朴素LRU(LRU-1)
 *
 * 查询和放入对于LRU的逻辑来说是没什么区别的
 * 区别仅在查询不存在evict操作
 **/
@Data
public class SimpleLRUDemo<K, V> extends BasicCacheAction<K, V> {

    /**
     * 链表的优势在于插入/删除, 如需优化查找性能可以+个map
     */
    private SimpleLRUCacheContext cache;

    public SimpleLRUDemo() {
        this.cache = new SimpleLRUCacheContext(4);
    }

    /**
     * 访问动作1: 缓存查询
     */
    public V get(K k) {
        LinkedHashMap<K, V> data =  this.cache.getData();
        // 1. 缓存命中
        if(data.containsKey(k)) {
            V v = data.get(k);
            update(k, v, this.cache);
            return v;
        }
        // 2. 缓存穿透 just do nothing
        return null;
    }

    /**
     * 访问动作2: 缓存放入
     */
    @Override
    public void put(K k, V v) {
        LinkedHashMap<K, V> data =  this.cache.getData();
        // 1. 缓存命中
        if(data.containsKey(k)) {
            update(k, v, this.cache);
        }
        // 2. 缓存穿透
        else {
            // 2.1 先进行淘汰操作
            evict(this.cache);
            // 2.2 添加新值进队首
            data.put(k, v);
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



    public static void main(String[] args) {
        SimpleLRUDemo<String, Integer> demo = new SimpleLRUDemo<>();
        demo.put("One", 1);
        demo.put("Two", 2);
        demo.put("Three", 3);
        demo.put("Four", 4);

        demo.put("Two", 3);
        demo.put("Five", 5);

        demo.get("One"); // get了个寂寞
        demo.get("Four");

        demo.printMyself(demo.getCache());
    }


}



