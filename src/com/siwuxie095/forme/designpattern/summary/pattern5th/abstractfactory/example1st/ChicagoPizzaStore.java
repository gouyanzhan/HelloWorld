package com.siwuxie095.forme.designpattern.summary.pattern5th.abstractfactory.example1st;

/**
 * 芝加哥比萨店
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:16:41
 */
class ChicagoPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza() {
        PizzaIngredientFactory ingredientFactory = new PizzaIngredientFactoryInChicago();
        return new Pizza(ingredientFactory);
    }
}
