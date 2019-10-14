package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 纽约风味的芝士比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:18:48
 */
class NewYorkStyleCheesePizza extends Pizza {

    public NewYorkStyleCheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        this.name = "New York Style Cheese Pizza";
        this.dough = ingredientFactory.createDough();
        this.sauce = ingredientFactory.createSauce();
        this.toppings = ingredientFactory.createToppings();
        printPrepare();
    }
}
