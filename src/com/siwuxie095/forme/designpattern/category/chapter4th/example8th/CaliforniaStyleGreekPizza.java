package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 加州风味的希腊比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:16:02
 */
class CaliforniaStyleGreekPizza extends Pizza {

    public CaliforniaStyleGreekPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        this.name = "California Style Greek Pizza";
        this.dough = ingredientFactory.createDough();
        this.sauce = ingredientFactory.createSauce();
        this.toppings = ingredientFactory.createToppings();
        printPrepare();
    }
}
