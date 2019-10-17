package com.siwuxie095.forme.designpattern.summary.pattern5th.abstractfactory.example1st;

/**
 * 加州风味的比萨原料工厂
 *
 * @author Jiajing Li
 * @date 2019-10-14 15:04:34
 */
class PizzaIngredientFactoryInCalifornia implements PizzaIngredientFactory {

    /*
     * 对于原料家族内的每一种原料，都提供了加州的版本。
     */

    @Override
    public Dough createDough() {
        return new DoughInCalifornia();
    }

    @Override
    public Sauce createSauce() {
        return new SauceInCalifornia();
    }

    @Override
    public Topping[] createToppings() {
        return new Topping[] {new ToppingInCalifornia()};
    }
}
