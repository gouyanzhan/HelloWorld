package com.siwuxie095.forme.designpattern.summary.pattern5th.abstractfactory.example1st;

/**
 * 纽约比萨店
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:18:35
 */
class NewYorkPizzaStore extends PizzaStore {


    @Override
    Pizza createPizza() {
        PizzaIngredientFactory ingredientFactory = new PizzaIngredientFactoryInNewYork();
        return new Pizza(ingredientFactory);
    }
}
