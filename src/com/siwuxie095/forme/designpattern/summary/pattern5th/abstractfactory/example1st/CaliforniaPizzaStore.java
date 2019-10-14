package com.siwuxie095.forme.designpattern.summary.pattern5th.abstractfactory.example1st;

/**
 * 加州比萨店
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:15:20
 */
class CaliforniaPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza() {
        PizzaIngredientFactory ingredientFactory = new PizzaIngredientFactoryInCalifornia();
        return new Pizza(ingredientFactory);
    }
}
