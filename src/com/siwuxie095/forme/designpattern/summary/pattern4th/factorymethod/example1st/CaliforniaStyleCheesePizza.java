package com.siwuxie095.forme.designpattern.summary.pattern4th.factorymethod.example1st;

/**
 * 加州风味的芝士比萨
 *
 * @author Jiajing Li
 * @date 2019-10-12 10:34:25
 */
class CaliforniaStyleCheesePizza extends Pizza {

    public CaliforniaStyleCheesePizza() {
        this.name = "California Style Cheese Pizza";
        this.dough = "California Style Dough For Cheese";
        this.sauce = "California Style Sauce For Cheese";
        this.toppings.add("California Style Topping For Cheese");
    }
}
