package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 加州风味的素食比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:16:30
 */
class CaliforniaStyleVeggiePizza extends Pizza {

    public CaliforniaStyleVeggiePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        this.name = "California Style Veggie Pizza";
        this.dough = ingredientFactory.createDough();
        this.sauce = ingredientFactory.createSauce();
        this.toppings = ingredientFactory.createToppings();
        printPrepare();
    }
}
