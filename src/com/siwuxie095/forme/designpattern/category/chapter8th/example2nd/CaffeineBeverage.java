package com.siwuxie095.forme.designpattern.category.chapter8th.example2nd;

/**
 * 咖啡因饮料
 *
 * @author Jiajing Li
 * @date 2019-11-05 14:14:01
 */
abstract class CaffeineBeverage {

    /**
     * 准备冲泡法
     */
    abstract void prepareRecipe();

    /**
     * 把水煮沸
     */
    void boilWater() {
        System.out.println("Boiling water");
    }

    /**
     * 把饮料倒进杯子
     */
    void pourInCup() {
        System.out.println("Pouring into cup");
    }




}
