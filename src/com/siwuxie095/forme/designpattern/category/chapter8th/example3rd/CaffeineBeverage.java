package com.siwuxie095.forme.designpattern.category.chapter8th.example3rd;

/**
 * 咖啡因饮料
 *
 * @author Jiajing Li
 * @date 2019-11-05 14:14:01
 */
abstract class CaffeineBeverage {

    /**
     * 准备冲泡法（模板方法）
     *
     * 每个步骤都被实现在分离的方法中。
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    /**
     * 把水煮沸
     */
    void boilWater() {
        System.out.println("Boiling water");
    }

    /**
     * 用热水泡咖啡或茶
     */
    abstract void brew();

    /**
     * 把饮料倒进杯子
     */
    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /**
     * 在饮料中加入适当的调料
     */
    abstract void addCondiments();

}
