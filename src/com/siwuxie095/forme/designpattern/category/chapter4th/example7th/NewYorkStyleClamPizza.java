package com.siwuxie095.forme.designpattern.category.chapter4th.example7th;

/**
 * 纽约风味的蛤蜊比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 10:52:32
 */
class NewYorkStyleClamPizza extends Pizza {

    public NewYorkStyleClamPizza() {
        this.name = "New York Style Clam Pizza";
        this.dough = "New York Style Dough For Clam";
        this.sauce = "New York Style Sauce For Clam";
        this.toppings.add("New York Style Topping For Clam");
    }

    @Override
    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }

}
