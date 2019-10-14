package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 加州比萨店
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:15:20
 */
class CaliforniaPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(PizzaType pizzaType) {
        Pizza pizza = null;

        PizzaIngredientFactory ingredientFactory = new PizzaIngredientFactoryInCalifornia();

        if (pizzaType == PizzaType.CHEESE) {
            pizza = new CaliforniaStyleCheesePizza(ingredientFactory);
        } else if (pizzaType == PizzaType.GREEK) {
            pizza = new CaliforniaStyleGreekPizza(ingredientFactory);
        } else if (pizzaType == PizzaType.PEPPERONI) {
            pizza = new CaliforniaStylePepperoniPizza(ingredientFactory);
        } else if (pizzaType == PizzaType.CLAM) {
            pizza = new CaliforniaStyleClamPizza(ingredientFactory);
        } else if (pizzaType == PizzaType.VEGGIE) {
            pizza = new CaliforniaStyleVeggiePizza(ingredientFactory);
        }

        return pizza;
    }
}
