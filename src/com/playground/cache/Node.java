package com.playground.cache;

import lombok.Data;

/**
 * @author: Vermouth
 * @create: 2021-06-18 14:32
 * @description:
 **/

@Data
public class Node<K, V> {
    K key;
    V value;
    int freq = 1;
    public Node() {}
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void incrFreq() {
        this.freq++;
    }
}
