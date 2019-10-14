package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 芝加哥比萨店
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:16:41
 */
class ChicagoPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(PizzaType pizzaType) {
        Pizza pizza = null;

        PizzaIngredientFactory ingredientFactory = new PizzaIngredientFactoryInChicago();

        if (pizzaType == PizzaType.CHEESE) {
            pizza = new ChicagoStyleCheesePizza(ingredientFactory);
        } else if (pizzaType == PizzaType.GREEK) {
            pizza = new ChicagoStyleGreekPizza(ingredientFactory);
        } else if (pizzaType == PizzaType.PEPPERONI) {
            pizza = new ChicagoStylePepperoniPizza(ingredientFactory);
        } else if (pizzaType == PizzaType.CLAM) {
            pizza = new ChicagoStyleClamPizza(ingredientFactory);
        } else if (pizzaType == PizzaType.VEGGIE) {
            pizza = new ChicagoStyleVeggiePizza(ingredientFactory);
        }

        return pizza;
    }
}
