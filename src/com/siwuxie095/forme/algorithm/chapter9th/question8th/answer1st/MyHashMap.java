package com.siwuxie095.forme.algorithm.chapter9th.question8th.answer1st;

import java.util.HashMap;

/**
 * @author Jiajing Li
 * @date 2019-06-23 21:28:14
 */
public class MyHashMap<K, V> {

    private HashMap<K, MyValue<V>> baseMap;

    private long time;

    private MyValue<V> setAll;

    public MyHashMap() {
        this.baseMap = new HashMap<>();
        this.time = 0;
        this.setAll = new MyValue<>(null, -1);
    }

    public boolean containsKey(K key) {
        return this.baseMap.containsKey(key);
    }

    public void put(K key, V value) {
        this.baseMap.put(key, new MyValue<>(value, this.time++));
    }

    public void setAll(V value) {
        this.setAll = new MyValue<>(value, this.time++);
    }

    public V get(K key) {
        if (this.containsKey(key)) {
            if (this.baseMap.get(key).getTime() > this.setAll.getTime()) {
                return this.baseMap.get(key).getValue();
            } else {
                return this.setAll.getValue();
            }
        } else {
            return null;
        }
    }


}
