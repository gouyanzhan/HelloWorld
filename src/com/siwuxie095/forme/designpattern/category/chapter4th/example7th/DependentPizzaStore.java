package com.siwuxie095.forme.designpattern.category.chapter4th.example7th;

/**
 * 依赖的比萨店
 *
 * @author Jiajing Li
 * @date 2019-10-14 10:55:49
 */
class DependentPizzaStore {

    Pizza orderPizza(RegionStyle regionStyle, PizzaType pizzaType) {
        Pizza pizza = null;

        if (regionStyle == RegionStyle.NEW_YORK_STYLE) {
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
        } else if (regionStyle == RegionStyle.CHICAGO_STYLE) {
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
        } else if (regionStyle == RegionStyle.CALIFORNIA_STYLE) {
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
        }

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

}
