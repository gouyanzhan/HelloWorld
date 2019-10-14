package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * @author Jiajing Li
 * @date 2019-10-14 14:18:12
 */
public class Main {

    /**
     * 现在，比萨店的设计已经很棒：具有弹性的框架，而且遵循设计原则。
     *
     * 但是比萨店成功的关键在于新鲜、高质量的原料，但是有些加盟店使
     * 用低价原料来增加利润。所以必须采取一些手段，以免长此以往毁了
     * 比萨店的名声。
     *
     *
     * 确保原料的一致
     *
     * 要如何确保每家加盟店使用高质量的原料？显然，统一建造一家生产
     * 原料的工厂，并将原料运送到各家加盟店，是一个不错的注意。
     *
     * 对于这种做法，还剩下一个问题：加盟店坐落在不同的区域，不同
     * 区域的原料是不一样的。比如，纽约风味比萨的面团和芝加哥风味
     * 比萨的面团是不一样的。所以，纽约使用一组原料，芝加哥使用另
     * 一种原料。原料便有了一个家族，即 原料家族（包含：面团、酱
     * 料和佐料）。
     *
     *
     * 建造原料工厂
     *
     * 现在建造一个原料工厂来生产原料，这个工厂将负责创建原料家族
     * 中的每一种原料，即 面团、酱料和佐料。
     * 先建造一个抽象原料工厂，然后再给各个区域建造具体的原料工厂。
     * 对于每个具体的原料工厂，都提供了特定版本的原料。
     *
     * 从今以后，加盟店必须直接从工厂取得原料，那些偷工减料的日子
     * 宣告结束了！
     *
     *
     * 做了什么
     *
     * 一连串的代码改变，到底做了些什么？
     *
     * 这里引入了新类型的工厂，也就是所谓的抽象工厂，来创建原料家族。
     * 通过抽象工厂提供的接口，可以创建产品的家族，利用这个接口书写
     * 代码，代码将从实际工厂中解耦，以便在不同上下文中实现各式各样
     * 的工厂，制造出不同的产品。例如：不同的区域、不同的操作系统、
     * 不同的外观及操作。
     * 因为代码从实际的产品中解耦了，所以可以替换不同的工厂来取得不
     * 同的行为。
     *
     * （1）抽象工厂为产品家族提供接口。
     * （2）从抽象工厂中派生出一些具体工厂，这些工厂产生相同的产品，
     * 但是产品的实现不同。
     * （3）使用工厂来创建产品。通过传入各种不同的工作，可以制作出
     * 各种不同的产品。但是客户的代码始终保持不变。
     */
    public static void main(String[] args) {
        PizzaStore newYorkPizzaStore = new NewYorkPizzaStore();
        Pizza newYorkPizza = newYorkPizzaStore.orderPizza(PizzaType.CHEESE);
        System.out.println();
        System.out.println("Jack ordered a " + newYorkPizza.getName());

        System.out.println();
        System.out.println();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        Pizza chicagoPizza = chicagoPizzaStore.orderPizza(PizzaType.PEPPERONI);
        System.out.println();
        System.out.println("Jessica ordered a " + chicagoPizza.getName());

        System.out.println();
        System.out.println();
        PizzaStore californiaPizzaStore = new CaliforniaPizzaStore();
        Pizza californiaPizza = californiaPizzaStore.orderPizza(PizzaType.VEGGIE);
        System.out.println();
        System.out.println("Jim ordered a " + californiaPizza.getName());
    }

}
