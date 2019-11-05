package com.siwuxie095.forme.designpattern.category.chapter8th.example2nd;

/**
 * 咖啡
 *
 * @author Jiajing Li
 * @date 2019-11-05 13:49:15
 */
class Coffee extends CaffeineBeverage {

    /**
     * 准备冲泡法
     *
     * 这是咖啡冲泡法，直接取自训练手册。
     * 每个步骤都被实现在分离的方法中。
     */
    @Override
    void prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    /**
     * 用沸水冲泡咖啡
     */
    void brewCoffeeGrinds() {
        System.out.println("Dripping coffee through filter");
    }

    /**
     * 加糖和牛奶
     */
    void addSugarAndMilk() {
        System.out.println("Adding Sugar and Milk");
    }

}
