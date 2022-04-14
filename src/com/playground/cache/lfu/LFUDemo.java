package com.playground.cache.lfu;

import com.playground.cache.Node;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author: Vermouth
 * @create: 2021-06-18 14:39
 * @description: 简单的LFU实现
 **/

public class LFUDemo<K, V> {

    Map<K, Node> cache;  // 存储缓存的内容
    Map<Integer, LinkedHashSet<Node>> freqMap; // 存储每个频次对应的双向链表
    int currentSize;
    int capacity; // 缓存容量
    int min; // 存储当前最小频次

    public LFUDemo(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    /**
     * 访问动作1: 查询
     */
    public V get(K key) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            return null;
        }
        freqInc(node);
        return node.getValue();
    }

    /**
     * 访问动作2: 插入
     */
    public void put(K key, V value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        // 1. 命中
        if (node != null) {
            node.setValue(value);
            freqInc(node);
        }
        // 2. 穿透
        else {
            if (currentSize == capacity) {
                Node deadNode = evictNode();
                cache.remove(deadNode.getKey());
                currentSize--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            currentSize++;
        }
    }

    /**
     * 计数器+1
     */
    void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.getFreq();
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.incrFreq();
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    /**
     * 添加新node
     */
    void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }


    Node evictNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }

    public static void main(String[] args) {
        LFUDemo<String, String> lfuDemo = new LFUDemo<>(4);

        lfuDemo.put("One", "One");
        lfuDemo.put("Two", "Two");
        lfuDemo.put("Three", "Three");
        lfuDemo.put("Four", "Four");
        lfuDemo.put("Five", "Five");
//        lfuDemo

    }

}
