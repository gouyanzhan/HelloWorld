package com.siwuxie095.forme.designpattern.category.chapter4th.example4th;

/**
 * 加州比萨店
 *
 * @author Jiajing Li
 * @date 2019-10-12 15:33:12
 */
class CaliforniaPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(PizzaType pizzaType) {
        Pizza pizza = null;

        if (pizzaType == PizzaType.CHEESE) {
            pizza = new CaliforniaStyleCheesePizza();
        } else if (pizzaType == PizzaType.GREEK) {
            pizza = new CaliforniaStyleGreekPizza();
        } else if (pizzaType == PizzaType.PEPPERONI) {
            pizza = new CaliforniaStylePepperoniPizza();
        } else if (pizzaType == PizzaType.CLAM) {
            pizza = new CaliforniaStyleClamPizza();
        } else if (pizzaType == PizzaType.VEGGIE) {
            pizza = new CaliforniaStyleVeggiePizza();
        }

        return pizza;
    }
}
