package com.siwuxie095.forme.designpattern.summary.pattern10th.templatemethod.example3rd;

/**
 * 咖啡因饮料
 *
 * @author Jiajing Li
 * @date 2019-11-05 14:14:01
 */
abstract class CaffeineBeverageWithHook {

    /**
     * 准备冲泡法（模板方法）
     *
     * 每个步骤都被实现在分离的方法中。
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        /*
         * 加上一个条件语句，而该条件是否成立，是由一个具体方法
         * customerWantsCondiments() 决定的。如果顾客 "想要"
         * 调料，只有这时才调用 addCondiments()。
         */
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    /**
     * 把水煮沸
     */
    final void boilWater() {
        System.out.println("Boiling water");
    }

    /**
     * 用热水泡咖啡或茶
     */
    abstract void brew();

    /**
     * 把饮料倒进杯子
     */
    final void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /**
     * 在饮料中加入适当的调料
     */
    abstract void addCondiments();

    /**
     * 客户是否想加调料（钩子方法）
     *
     * 该方法不做别的事，默认返回 true。子类可以覆盖这个方法，
     * 但不见得一定要这么做。
     */
    boolean customerWantsCondiments() {
        return true;
    }

}
