package com.siwuxie095.forme.designpattern.category.chapter11th.example1st;

/**
 * 糖果机
 *
 * @author Jiajing Li
 * @date 2019-11-08 21:11:08
 */
class GumballMachine {

    /**
     * 糖果机地点
     */
    private String location;

    /**
     * 糖果数量
     */
    private int count;

    public GumballMachine(String location, int count) {
        this.location = location;
        this.count = count;
    }

    public String getLocation() {
        return location;
    }

    public int getCount() {
        return count;
    }
}
