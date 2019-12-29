package com.siwuxie095.forme.designpattern.category.chapter14th.example8th;

/**
 * @author Jiajing Li
 * @date 2019-11-11 17:38:00
 */
public class Main {

    /**
     * 享元模式
     */
    public static void main(String[] args) {
        Flyweight flyweight1 = FlyweightFactory.getFlyweight("A");
        flyweight1.operation("1st");
        Flyweight flyweight2 = FlyweightFactory.getFlyweight("B");
        flyweight2.operation("1st");
        Flyweight flyweight3 = FlyweightFactory.getFlyweight("C");
        flyweight3.operation("1st");

        System.out.println();
        Flyweight flyweight4 = FlyweightFactory.getFlyweight("A");
        flyweight4.operation("2nd");

        System.out.println();
        Flyweight unsharedConcreteFlyweight = new UnsharedConcreteFlyweight("X");
        unsharedConcreteFlyweight.operation("1st");

    }

}
