package com.siwuxie095.forme.designpattern.summary.pattern5th.abstractfactory.example1st;

/**
 * 比萨店
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:24:14
 */
abstract class PizzaStore {

    Pizza orderPizza() {
        Pizza pizza = createPizza();

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    abstract Pizza createPizza();

}
