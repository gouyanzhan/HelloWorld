package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 芝加哥风味的希腊比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:17:37
 */
class ChicagoStyleGreekPizza extends Pizza {

    public ChicagoStyleGreekPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        this.name = "Chicago Style Greek Pizza";
        this.dough = ingredientFactory.createDough();
        this.sauce = ingredientFactory.createSauce();
        this.toppings = ingredientFactory.createToppings();
        printPrepare();
    }
}
