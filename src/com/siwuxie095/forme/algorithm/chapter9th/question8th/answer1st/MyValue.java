package com.siwuxie095.forme.algorithm.chapter9th.question8th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-23 21:28:05
 */
public class MyValue<V> {

    private V value;

    private long time;

    public MyValue(V value, long time) {
        this.value = value;
        this.time = time;
    }

    public V getValue() {
        return this.value;
    }

    public long getTime() {
        return this.time;
    }

}
