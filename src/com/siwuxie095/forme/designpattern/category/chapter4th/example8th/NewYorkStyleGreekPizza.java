package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 纽约风味的希腊比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:19:24
 */
class NewYorkStyleGreekPizza extends Pizza {

    public NewYorkStyleGreekPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        this.name = "New York Style Greek Pizza";
        this.dough = ingredientFactory.createDough();
        this.sauce = ingredientFactory.createSauce();
        this.toppings = ingredientFactory.createToppings();
        printPrepare();
    }
}
