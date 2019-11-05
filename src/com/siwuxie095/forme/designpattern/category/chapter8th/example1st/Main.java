package com.siwuxie095.forme.designpattern.category.chapter8th.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-05 14:00:57
 */
public class Main {

    /**
     * 封装算法
     *
     * 直到目前，我们的议题都绕着封装转。我们已经封装了对象创建、方法调用、复杂接口 ...
     * 接下来，将要深入封装算法块，好让子类可以在任何时候都可以将自己挂接进运算里。
     *
     *
     * 以咖啡和茶为例说明：
     * 咖啡和茶的共同成分是咖啡因，而且二者的冲泡方式非常类似。
     *
     * 咖啡冲泡法：
     * （1）把水煮沸
     * （2）用沸水冲泡咖啡
     * （3）把咖啡倒进杯子
     * （4）加糖和牛奶
     *
     * 茶冲泡法：
     * （1）把水煮沸
     * （2）用沸水浸泡茶叶
     * （3）把茶倒进杯子
     * （4）加柠檬
     *
     * 在本例中，Coffee 和 Tea 中，boilWater() 方法和 pourInCup() 方法完全一样，
     * 也就是出现了重复的代码。这表示需要清理一下当前的设计，既然咖啡和茶如此相似，就
     * 应该将共同的部分抽取出来，放进一个基类中。
     */
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.prepareRecipe();

        System.out.println();

        Tea tea = new Tea();
        tea.prepareRecipe();
    }

}
