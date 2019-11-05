package com.siwuxie095.forme.designpattern.category.chapter8th.example1st;

/**
 * 茶
 *
 * @author Jiajing Li
 * @date 2019-11-05 13:49:27
 */
class Tea {

    /**
     * 准备冲泡法
     *
     * 这是茶冲泡法，直接取自训练手册。
     * 每个步骤都被实现在分离的方法中。
     */
    void prepareRecipe() {
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }

    /**
     * 把水煮沸
     */
    void boilWater() {
        System.out.println("Boiling water");
    }

    /**
     * 用沸水浸泡茶叶
     */
    void steepTeaBag() {
        System.out.println("Steeping the tea");
    }

    /**
     * 把咖啡倒进杯子
     */
    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /**
     * 加柠檬
     */
    void addLemon() {
        System.out.println("Adding Lemon");
    }

}
