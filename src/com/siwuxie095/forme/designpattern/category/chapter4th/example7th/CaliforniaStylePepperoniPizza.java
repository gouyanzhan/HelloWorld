package com.siwuxie095.forme.designpattern.category.chapter4th.example7th;

/**
 * 加州风味的腊肠比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 10:49:30
 */
class CaliforniaStylePepperoniPizza extends Pizza {

    public CaliforniaStylePepperoniPizza() {
        this.name = "California Style Pepperoni Pizza";
        this.dough = "California Style Dough For Pepperoni";
        this.sauce = "California Style Sauce For Pepperoni";
        this.toppings.add("California Style Topping For Pepperoni");
    }
}
