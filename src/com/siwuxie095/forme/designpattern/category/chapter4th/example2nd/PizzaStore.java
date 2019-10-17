package com.siwuxie095.forme.designpattern.category.chapter4th.example2nd;

/**
 * 比萨店
 *
 * @author Jiajing Li
 * @date 2019-10-12 10:36:09
 */
class PizzaStore {

    /**
     * 为 PizzaStore 加上一个对 SimplePizzaFactory 的引用。
     */
    private SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    Pizza orderPizza(PizzaType pizzaType) {
        /*
         * 通过传入比萨类型来使用工厂创建比萨。
         *
         * 这里把 new 操作符替换成工厂对象 factory 的创建
         * 方法 createPizza()。
         *
         * 这里不再使用具体实例化。
         */
        Pizza pizza = factory.createPizza(pizzaType);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

}
