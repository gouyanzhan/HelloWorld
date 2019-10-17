package com.siwuxie095.forme.designpattern.category.chapter4th.example4th;

/**
 * 比萨店
 *
 * @author Jiajing Li
 * @date 2019-10-12 10:36:09
 */
abstract class PizzaStore {

    /**
     * 为防止 orderPizza() 被子类覆盖，可以把该方法
     * 声明为 final。
     *
     *
     * 超类 PizzaStore 的 orderPizza() 并不知道正
     * 在创建的比萨是哪一种，它只知道这个比萨可以被准
     * 备、被烘烤、被切片、被装盒。
     */
    Pizza orderPizza(PizzaType pizzaType) {
        /*
         * 现在， createPizza() 方法从工厂对象中
         * 移回 PizzaStore。
         */
        Pizza pizza = createPizza(pizzaType);

        /*
         * 这些步骤依然不变。
         */
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    /**
     * 在 PizzaStore 中，"工厂方法" 现在是抽象的。
     *
     * 现在实例化比萨的责任被移到一个 "方法" 中，此
     * 方法就如同是一个 "工厂"。故而称为 "工厂方法"。
     *
     * "工厂方法" 用来处理对象的创建，并将这样的行为
     * 封装在子类中。
     *
     *
     * 每个子类都会覆盖该方法，以提供不同风味的比萨。
     */
    abstract Pizza createPizza(PizzaType pizzaType);

}
