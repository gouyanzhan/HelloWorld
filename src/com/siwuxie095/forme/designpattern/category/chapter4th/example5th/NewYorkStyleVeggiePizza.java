package com.siwuxie095.forme.designpattern.category.chapter4th.example5th;

/**
 * 纽约风味的素食比萨
 *
 * @author Jiajing Li
 * @date 2019-10-12 10:37:56
 */
class NewYorkStyleVeggiePizza extends Pizza {

    public NewYorkStyleVeggiePizza() {
        this.name = "New York Style Veggie Pizza";
        this.dough = "New York Style Dough For Veggie";
        this.sauce = "New York Style Sauce For Veggie";
        this.toppings.add("New York Style Topping For Veggie");
    }

}
