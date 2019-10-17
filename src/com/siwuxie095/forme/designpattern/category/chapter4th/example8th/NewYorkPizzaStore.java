package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 纽约比萨店
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:18:35
 */
class NewYorkPizzaStore extends PizzaStore {

    /**
     * 子类全权负责该实例化哪一个具体比萨。
     */
    @Override
    Pizza createPizza(PizzaType pizzaType) {
        Pizza pizza = null;

        PizzaIngredientFactory ingredientFactory = new PizzaIngredientFactoryInNewYork();

        if (pizzaType == PizzaType.CHEESE) {
            pizza = new NewYorkStyleCheesePizza(ingredientFactory);
        } else if (pizzaType == PizzaType.GREEK) {
            pizza = new NewYorkStyleGreekPizza(ingredientFactory);
        } else if (pizzaType == PizzaType.PEPPERONI) {
            pizza = new NewYorkStylePepperoniPizza(ingredientFactory);
        } else if (pizzaType == PizzaType.CLAM) {
            pizza = new NewYorkStyleClamPizza(ingredientFactory);
        } else if (pizzaType == PizzaType.VEGGIE) {
            pizza = new NewYorkStyleVeggiePizza(ingredientFactory);
        }

        return pizza;
    }
}
