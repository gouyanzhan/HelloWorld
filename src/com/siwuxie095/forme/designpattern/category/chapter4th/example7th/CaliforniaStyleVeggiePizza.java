package com.siwuxie095.forme.designpattern.category.chapter4th.example7th;

/**
 * 加州风味的素食比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 10:50:16
 */
class CaliforniaStyleVeggiePizza extends Pizza {

    public CaliforniaStyleVeggiePizza() {
        this.name = "California Style Veggie Pizza";
        this.dough = "California Style Dough For Veggie";
        this.sauce = "California Style Sauce For Veggie";
        this.toppings.add("California Style Topping For Veggie");
    }
}
