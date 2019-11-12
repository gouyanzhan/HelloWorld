package com.siwuxie095.forme.designpattern.summary.pattern23th.visitor.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-11 22:52:04
 */
public class Main {

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
