package com.siwuxie095.forme.designpattern.category.chapter4th.example3rd.newyork;

/**
 * @author Jiajing Li
 * @date 2019-10-12 10:35:15
 */
public class Main {

    public static void main(String[] args) {
        NewYorkPizzaFactory factory = new NewYorkPizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(factory);
        pizzaStore.orderPizza(PizzaType.CHEESE);
        pizzaStore.orderPizza(PizzaType.CLAM);
        pizzaStore.orderPizza(PizzaType.VEGGIE);
    }

}
