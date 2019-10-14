package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 加州风味的蛤蜊比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:15:47
 */
class CaliforniaStyleClamPizza extends Pizza {

    public CaliforniaStyleClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        this.name = "California Style Clam Pizza";
        this.dough = ingredientFactory.createDough();
        this.sauce = ingredientFactory.createSauce();
        this.toppings = ingredientFactory.createToppings();
        printPrepare();
    }
}
