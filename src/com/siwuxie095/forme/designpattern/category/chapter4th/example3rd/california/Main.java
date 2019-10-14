package com.siwuxie095.forme.designpattern.category.chapter4th.example3rd.california;

/**
 * @author Jiajing Li
 * @date 2019-10-12 10:35:15
 */
public class Main {

    public static void main(String[] args) {
        CaliforniaPizzaFactory factory = new CaliforniaPizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(factory);
        pizzaStore.orderPizza(PizzaType.CHEESE);
        pizzaStore.orderPizza(PizzaType.CLAM);
        pizzaStore.orderPizza(PizzaType.VEGGIE);
    }

}
