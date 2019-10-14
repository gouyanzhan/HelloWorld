package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 加州风味的芝士比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:15:33
 */
class CaliforniaStyleCheesePizza extends Pizza {

    public CaliforniaStyleCheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        this.name = "California Style Cheese Pizza";
        this.dough = ingredientFactory.createDough();
        this.sauce = ingredientFactory.createSauce();
        this.toppings = ingredientFactory.createToppings();
        printPrepare();
    }
}
