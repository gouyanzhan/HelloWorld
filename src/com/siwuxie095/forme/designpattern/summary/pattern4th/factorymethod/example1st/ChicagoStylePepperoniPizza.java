package com.siwuxie095.forme.designpattern.summary.pattern4th.factorymethod.example1st;

/**
 * 芝加哥风味的腊肠比萨
 *
 * @author Jiajing Li
 * @date 2019-10-12 10:35:31
 */
class ChicagoStylePepperoniPizza extends Pizza {

    public ChicagoStylePepperoniPizza() {
        this.name = "Chicago Style Pepperoni Pizza";
        this.dough = "Chicago Style Dough For Pepperoni";
        this.sauce = "Chicago Style Sauce For Pepperoni";
        this.toppings.add("Chicago Style Topping For Pepperoni");
    }
}
