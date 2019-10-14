package com.siwuxie095.forme.designpattern.category.chapter4th.example2nd;

/**
 * 简单的比萨工厂
 *
 * @author Jiajing Li
 * @date 2019-10-12 10:38:44
 */
class SimplePizzaFactory {

    /**
     * SimplePizzaFactory 只做一件事情：帮它的客户创建比萨。
     */
    Pizza createPizza(PizzaType pizzaType) {
        Pizza pizza = null;

        if (pizzaType == PizzaType.CHEESE) {
            pizza = new CheesePizza();
        } else if (pizzaType == PizzaType.GREEK) {
            pizza = new GreekPizza();
        } else if (pizzaType == PizzaType.PEPPERONI) {
            pizza = new PepperoniPizza();
        } else if (pizzaType == PizzaType.CLAM) {
            pizza = new ClamPizza();
        } else if (pizzaType == PizzaType.VEGGIE) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }


}
