package com.siwuxie095.forme.designpattern.category.chapter8th.example2nd;

/**
 * @author Jiajing Li
 * @date 2019-11-05 14:19:31
 */
public class Main {

    /**
     * 第一版设计
     *
     * prepareRecipe() 方法在每个类中都不一样，所以定义成抽象方法。
     *
     * boilWater() 和 pourInCup() 方法被两个子类所共享，所以被定义在超类中。
     *
     * 每个子类都覆盖 prepareRecipe() 方法实现了自己的冲泡法。
     *
     * 咖啡和茶特有的方法放在子类中。
     *
     *
     * 在这一版的设计中，似乎忽略了某些其他的共同点。
     */
    public static void main(String[] args) {
        CaffeineBeverage coffee = new Coffee();
        coffee.prepareRecipe();

        System.out.println();

        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();
    }

}
