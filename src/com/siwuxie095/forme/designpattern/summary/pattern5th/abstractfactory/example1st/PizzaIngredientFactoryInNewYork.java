package com.siwuxie095.forme.designpattern.summary.pattern5th.abstractfactory.example1st;

/**
 * 纽约风味的比萨原料工厂
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:59:36
 */
class PizzaIngredientFactoryInNewYork implements PizzaIngredientFactory {

    /*
     * 对于原料家族内的每一种原料，都提供了纽约的版本。
     */

    @Override
    public Dough createDough() {
        return new DoughInNewYork();
    }

    @Override
    public Sauce createSauce() {
        return new SauceInNewYork();
    }

    @Override
    public Topping[] createToppings() {
        return new Topping[] {new ToppingInNewYork()};
    }
}
