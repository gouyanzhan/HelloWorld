package com.siwuxie095.forme.designpattern.category.chapter8th.example1st;

/**
 * 咖啡
 *
 * @author Jiajing Li
 * @date 2019-11-05 13:49:15
 */
class Coffee {

    /**
     * 准备冲泡法
     *
     * 这是咖啡冲泡法，直接取自训练手册。
     * 每个步骤都被实现在分离的方法中。
     */
    void prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    /**
     * 把水煮沸
     */
    void boilWater() {
        System.out.println("Boiling water");
    }

    /**
     * 用沸水冲泡咖啡
     */
    void brewCoffeeGrinds() {
        System.out.println("Dripping coffee through filter");
    }

    /**
     * 把咖啡倒进杯子
     */
    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /**
     * 加糖和牛奶
     */
    void addSugarAndMilk() {
        System.out.println("Adding Sugar and Milk");
    }

}
