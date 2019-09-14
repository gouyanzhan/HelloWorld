package com.siwuxie095.forme.designpattern.category.chapter3rd.example1st;

/**
 * 饮料
 *
 * @author Jiajing Li
 * @date 2019-09-14 17:12:45
 */
abstract class Beverage {

    /**
     * 饮料描述
     */
    private String description;

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
