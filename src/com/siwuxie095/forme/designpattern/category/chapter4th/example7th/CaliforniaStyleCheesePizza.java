package com.siwuxie095.forme.designpattern.category.chapter4th.example7th;

/**
 * 加州风味的芝士比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 10:48:32
 */
class CaliforniaStyleCheesePizza extends Pizza {

    public CaliforniaStyleCheesePizza() {
        this.name = "California Style Cheese Pizza";
        this.dough = "California Style Dough For Cheese";
        this.sauce = "California Style Sauce For Cheese";
        this.toppings.add("California Style Topping For Cheese");
    }
}
