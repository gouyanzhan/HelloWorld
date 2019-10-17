package com.siwuxie095.forme.designpattern.summary.pattern4th.factorymethod.example1st;

/**
 * 加州风味的腊肠比萨
 *
 * @author Jiajing Li
 * @date 2019-10-12 10:35:31
 */
class CaliforniaStylePepperoniPizza extends Pizza {

    public CaliforniaStylePepperoniPizza() {
        this.name = "California Style Pepperoni Pizza";
        this.dough = "California Style Dough For Pepperoni";
        this.sauce = "California Style Sauce For Pepperoni";
        this.toppings.add("California Style Topping For Pepperoni");
    }
}
