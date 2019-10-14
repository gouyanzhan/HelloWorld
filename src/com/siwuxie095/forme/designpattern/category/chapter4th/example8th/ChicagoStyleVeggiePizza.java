package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 芝加哥风味的素食比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:18:00
 */
class ChicagoStyleVeggiePizza extends Pizza {

    public ChicagoStyleVeggiePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        this.name = "Chicago Style Veggie Pizza";
        this.dough = ingredientFactory.createDough();
        this.sauce = ingredientFactory.createSauce();
        this.toppings = ingredientFactory.createToppings();
        printPrepare();
    }
}
