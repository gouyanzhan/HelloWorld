package com.siwuxie095.forme.designpattern.category.chapter4th.example7th;

/**
 * 芝加哥风味的希腊比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 10:51:23
 */
class ChicagoStyleGreekPizza extends Pizza {

    public ChicagoStyleGreekPizza() {
        this.name = "Chicago Style Greek Pizza";
        this.dough = "Chicago Style Dough For Greek";
        this.sauce = "Chicago Style Sauce For Greek";
        this.toppings.add("Chicago Style Topping For Greek");
    }
}
