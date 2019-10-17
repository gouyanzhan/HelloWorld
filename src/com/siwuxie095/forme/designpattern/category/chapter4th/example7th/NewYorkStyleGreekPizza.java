package com.siwuxie095.forme.designpattern.category.chapter4th.example7th;

/**
 * 纽约风味的希腊比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 10:52:57
 */
class NewYorkStyleGreekPizza extends Pizza {

    public NewYorkStyleGreekPizza() {
        this.name = "New York Style Greek Pizza";
        this.dough = "New York Style Dough For Greek";
        this.sauce = "New York Style Sauce For Greek";
        this.toppings.add("New York Style Topping For Greek");
    }
}
