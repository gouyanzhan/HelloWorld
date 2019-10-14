package com.siwuxie095.forme.designpattern.category.chapter4th.example5th;

/**
 * @author Jiajing Li
 * @date 2019-10-12 15:19:29
 */
public class Main {

    /**
     * 刚刚忽略了一件事：比萨本身！
     *
     * 即 比萨本身还是空空如也。如果没有比萨出售，店开的再多也没用。
     *
     * 所以，实现比萨！
     *
     *
     * 认识工厂方法模式
     *
     * 所有工厂模式都用来封装对象的创建。工厂方法模式通过让子类决定
     * 该创建的对象是什么，来达到将对象创建的过程封装的目的。
     *
     * 工厂方法模式主要是包含两种平行关系的类：
     * （1）创建者类（Creator）：抽象创建者和具体创建者。
     * （2）产品类（Product）：抽象产品和具体产品。
     *
     * 之所以是平行关系，就是因为二者都有抽象类，而抽象类又都有许多
     * 具体的子类，每个子类都有自己特定的实现。
     *
     * 在本例中，PizzaStore 属于创建者类，是抽象创建者，它定义了
     * 一个抽象的工厂方法，让子类实现此方法制造产品。
     *
     * createPizza() 方法正是工厂方法，用来制造产品。
     *
     * 抽象创建者通常会包含依赖于抽象产品的代码，而这些抽象产品由
     * 具体创建者制造，抽象创建者不需要真的知道在制造哪种具体产品。
     *
     * 而 Pizza 则属于产品类，是抽象产品，它的子类则是具体产品。
     *
     *
     * 可以看到，将一个 orderPizza() 方法和一个工厂方法联合起来，
     * 就可以成为一个框架。
     * 除此之外，工厂方法将生产知识封装进各个创建者，这样的做法，也
     * 可以被视为一个框架。比如，NewYorkPizzaStore 所封装的知识
     * 是如何制作纽约风味的比萨。工厂方法正是封装这种知识的关键所在。
     */
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
