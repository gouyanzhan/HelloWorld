package com.siwuxie095.forme.designpattern.summary.pattern4th.factorymethod.example1st;

/**
 * @author Jiajing Li
 * @date 2019-10-12 15:19:29
 */
public class Main {

    public static void main(String[] args) {
        PizzaStore newYorkPizzaStore = new NewYorkPizzaStore();
        Pizza newYorkPizza = newYorkPizzaStore.orderPizza(PizzaType.CHEESE);
        System.out.println();
        System.out.println("Jack ordered a " + newYorkPizza.getName());

        System.out.println();
        System.out.println();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        Pizza chicagoPizza = chicagoPizzaStore.orderPizza(PizzaType.PEPPERONI);
        System.out.println();
        System.out.println("Jessica ordered a " + chicagoPizza.getName());

        System.out.println();
        System.out.println();
        PizzaStore californiaPizzaStore = new CaliforniaPizzaStore();
        Pizza californiaPizza = californiaPizzaStore.orderPizza(PizzaType.VEGGIE);
        System.out.println();
        System.out.println("Jim ordered a " + californiaPizza.getName());
    }

}
