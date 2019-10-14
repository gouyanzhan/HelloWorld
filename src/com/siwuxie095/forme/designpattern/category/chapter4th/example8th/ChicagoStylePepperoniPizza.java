package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 芝加哥风味的腊肠比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:17:48
 */
class ChicagoStylePepperoniPizza extends Pizza {

    public ChicagoStylePepperoniPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        this.name = "Chicago Style Pepperoni Pizza";
        this.dough = ingredientFactory.createDough();
        this.sauce = ingredientFactory.createSauce();
        this.toppings = ingredientFactory.createToppings();
        printPrepare();
    }
}
