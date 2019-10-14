package com.siwuxie095.forme.designpattern.category.chapter4th.example5th;

/**
 * 纽约比萨店
 *
 * @author Jiajing Li
 * @date 2019-10-12 15:31:43
 */
class NewYorkPizzaStore extends PizzaStore {

    /**
     * 子类全权负责该实例化哪一个具体比萨。
     */
    @Override
    Pizza createPizza(PizzaType pizzaType) {
        Pizza pizza = null;

        if (pizzaType == PizzaType.CHEESE) {
            pizza = new NewYorkStyleCheesePizza();
        } else if (pizzaType == PizzaType.GREEK) {
            pizza = new NewYorkStyleGreekPizza();
        } else if (pizzaType == PizzaType.PEPPERONI) {
            pizza = new NewYorkStylePepperoniPizza();
        } else if (pizzaType == PizzaType.CLAM) {
            pizza = new NewYorkStyleClamPizza();
        } else if (pizzaType == PizzaType.VEGGIE) {
            pizza = new NewYorkStyleVeggiePizza();
        }

        return pizza;
    }
}
