package com.siwuxie095.forme.designpattern.summary.pattern4th.factorymethod.example1st;

/**
 * 芝加哥比萨店
 *
 * @author Jiajing Li
 * @date 2019-10-12 15:32:27
 */
class ChicagoPizzaStore extends PizzaStore {

    @Override
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
