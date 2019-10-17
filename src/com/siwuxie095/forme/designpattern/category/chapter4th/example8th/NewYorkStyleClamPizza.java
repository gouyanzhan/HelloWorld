package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 纽约风味的蛤蜊比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:19:13
 */
class NewYorkStyleClamPizza extends Pizza {

    public NewYorkStyleClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        this.name = "New York Style Clam Pizza";
        this.dough = ingredientFactory.createDough();
        this.sauce = ingredientFactory.createSauce();
        this.toppings = ingredientFactory.createToppings();
        printPrepare();
    }

    @Override
    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }

}
