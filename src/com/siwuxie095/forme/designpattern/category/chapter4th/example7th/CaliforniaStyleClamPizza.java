package com.siwuxie095.forme.designpattern.category.chapter4th.example7th;

/**
 * 加州风味的蛤蜊比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 10:48:55
 */
class CaliforniaStyleClamPizza extends Pizza {

    public CaliforniaStyleClamPizza() {
        this.name = "California Style Clam Pizza";
        this.dough = "California Style Dough For Clam";
        this.sauce = "California Style Sauce For Clam";
        this.toppings.add("California Style Topping For Clam");
    }
}
