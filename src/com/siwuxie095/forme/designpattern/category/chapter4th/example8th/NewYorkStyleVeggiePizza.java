package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 纽约风味的素食比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:19:57
 */
class NewYorkStyleVeggiePizza extends Pizza {

    public NewYorkStyleVeggiePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        this.name = "New York Style Veggie Pizza";
        this.dough = ingredientFactory.createDough();
        this.sauce = ingredientFactory.createSauce();
        this.toppings = ingredientFactory.createToppings();
        printPrepare();
    }
}
