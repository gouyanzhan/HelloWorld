package com.siwuxie095.forme.designpattern.category.chapter14th.example17th;

/**
 * @author Jiajing Li
 * @date 2019-11-11 22:52:04
 */
public class Main {

    /**
     * 访问者模式
     *
     * 为一个对象的组合增加新的能力，且封装并不重要。
     *
     *
     * 现在有一个菜单与菜单项的组合，顾客在买单前总是想要了解某个菜单项的原料是什么，
     * 甚至想知道原料的营养成分是什么。为了不暴露菜单项和原料的实现，就需要加入访问
     * 者。访问者必须参观组合内的每个元素，同时收集组合中所有对象的状态。一旦状态被
     * 收集了，客户就可以让访问者对状态进行各种操作。当需要新功能时，只要加强访问者
     * 即可。
     *
     *
     * 访问者的优点：
     * （1）允许你对组合结构加入新的操作，而无需改变结构本身。
     * （2）想要加入新的操作，相对容易。
     * （3）访问者所进行的操作，其代码是集中在一起的。
     *
     * 访问者的用途和缺点：
     * （1）当采用访问者模式的时候，就会打破组合类的封装。
     * （2）因为游走的功能牵涉其中，所以对组合结构的改变就更加
     * 困难。
     */
    public static void main(String[] args) {

        MenuComponent menuItem = new MenuItem("午餐 A", "午餐 A：...", true, 15.99);

        MenuComponent materialA = new Material("原料 A");
        MenuComponent materialB = new Material("原料 B");

        menuItem.add(materialA);
        menuItem.add(materialB);

        Visitor visitor = new ConcreteVisitor();
        menuItem.getState(visitor);
        materialA.getState(visitor);
        materialB.getState(visitor);
    }

}
