package com.siwuxie095.forme.designpattern.category.chapter8th.example7th;

/**
 * 鸭子
 *
 * 需要实现 Comparable 接口，因为无法真的让鸭子数组去继承数组
 *
 * @author Jiajing Li
 * @date 2019-11-05 17:07:29
 */
class Duck implements Comparable {

    private String name;

    private int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + " weighs " + weight;
    }

    @Override
    public int compareTo(Object o) {
        Duck otherDuck = (Duck) o;
        if (this.weight < otherDuck.weight) {
            return -1;
        } else if (this.weight == otherDuck.weight) {
            return 0;
        } else {
            return 1;
        }
    }
}
