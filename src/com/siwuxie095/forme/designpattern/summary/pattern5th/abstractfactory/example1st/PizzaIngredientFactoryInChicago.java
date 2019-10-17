package com.siwuxie095.forme.designpattern.summary.pattern5th.abstractfactory.example1st;

/**
 * 芝加哥风味的比萨原料工厂
 *
 * @author Jiajing Li
 * @date 2019-10-14 15:02:25
 */
class PizzaIngredientFactoryInChicago implements PizzaIngredientFactory {
    /*
     * 对于原料家族内的每一种原料，都提供了芝加哥的版本。
     */

    @Override
    public Dough createDough() {
        return new DoughInChicago();
    }

    @Override
    public Sauce createSauce() {
        return new SauceInChicago();
    }

    @Override
    public Topping[] createToppings() {
        return new Topping[] {new ToppingInChicago()};
    }
}
