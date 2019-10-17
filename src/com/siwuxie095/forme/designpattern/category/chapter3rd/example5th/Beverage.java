package com.siwuxie095.forme.designpattern.category.chapter3rd.example5th;

/**
 * 饮料（组件）
 *
 * @author Jiajing Li
 * @date 2019-10-10 11:29:57
 */
abstract class Beverage {

    /**
     * 饮料描述
     */
    String description = "Unknown Beverage";

    /**
     * 这里已经实现了 getDescription() 方法
     */
    public String getDescription() {
        return description;
    }

    /**
     * cost() 方法必须在子类中实现
     */
    public abstract double cost();

    /**
     * 小杯
     */
    static final int TALL = 1;

    /**
     * 中杯
     */
    static final int GRANDE = 2;

    /**
     * 大杯
     */
    static final int VENTI = 3;

    /**
     * 容量
     */
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) throws Exception {
        if (size != TALL && size != GRANDE && size != VENTI) {
            throw new Exception(String.format("the size is illegal, size = %s.", size));
        }
        this.size = size;
    }
}
