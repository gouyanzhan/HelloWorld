package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 芝加哥风味的芝士比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:17:14
 */
class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        this.name = "Chicago Style Cheese Pizza";
        this.dough = ingredientFactory.createDough();
        this.sauce = ingredientFactory.createSauce();
        this.toppings = ingredientFactory.createToppings();
        printPrepare();
    }
}
