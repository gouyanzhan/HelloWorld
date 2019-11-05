package com.siwuxie095.forme.designpattern.category.chapter8th.example3rd;

/**
 * 咖啡
 *
 * @author Jiajing Li
 * @date 2019-11-05 13:49:15
 */
class Coffee extends CaffeineBeverage {

    /**
     * 用沸水冲泡咖啡
     */
    @Override
    void brew() {
        System.out.println("Dripping coffee through filter");
    }

    /**
     * 加糖和牛奶
     */
    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
