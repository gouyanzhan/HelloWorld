package com.siwuxie095.forme.designpattern.summary.pattern4th.factorymethod.example1st;

/**
 * 纽约风味的芝士比萨
 *
 * @author Jiajing Li
 * @date 2019-10-12 10:34:25
 */
class NewYorkStyleCheesePizza extends Pizza {

    public NewYorkStyleCheesePizza() {
        this.name = "New York Style Cheese Pizza";
        this.dough = "New York Style Dough For Cheese";
        this.sauce = "New York Style Sauce For Cheese";
        this.toppings.add("New York Style Topping For Cheese");
    }
}
