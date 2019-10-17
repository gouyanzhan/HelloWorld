package com.siwuxie095.forme.designpattern.category.chapter4th.example7th;

/**
 * 加州风味的希腊比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 10:49:09
 */
class CaliforniaStyleGreekPizza extends Pizza {

    public CaliforniaStyleGreekPizza() {
        this.name = "California Style Greek Pizza";
        this.dough = "California Style Dough For Greek";
        this.sauce = "California Style Sauce For Greek";
        this.toppings.add("California Style Topping For Greek");
    }
}
