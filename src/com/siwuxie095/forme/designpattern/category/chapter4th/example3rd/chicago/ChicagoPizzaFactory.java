package com.siwuxie095.forme.designpattern.category.chapter4th.example3rd.chicago;

/**
 * 芝加哥比萨工厂
 *
 * @author Jiajing Li
 * @date 2019-10-12 14:05:30
 */
class ChicagoPizzaFactory {

    Pizza createPizza(PizzaType pizzaType) {
        Pizza pizza = null;

        if (pizzaType == PizzaType.CHEESE) {
            pizza = new ChicagoStyleCheesePizza();
        } else if (pizzaType == PizzaType.GREEK) {
            pizza = new ChicagoStyleGreekPizza();
        } else if (pizzaType == PizzaType.PEPPERONI) {
            pizza = new ChicagoStylePepperoniPizza();
        } else if (pizzaType == PizzaType.CLAM) {
            pizza = new ChicagoStyleClamPizza();
        } else if (pizzaType == PizzaType.VEGGIE) {
            pizza = new ChicagoStyleVeggiePizza();
        }

        return pizza;
    }

}
