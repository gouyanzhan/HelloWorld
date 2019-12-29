package com.siwuxie095.forme.designpattern.category.chapter14th.example18th;

/**
 * @author Jiajing Li
 * @date 2019-11-11 22:52:25
 */
public class Main {

    /**
     * 访问者模式
     */
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new ConcreteElementA());
        objectStructure.add(new ConcreteElementB());
        Visitor concreteVisitor1st = new ConcreteVisitor1st();
        Visitor concreteVisitor2nd = new ConcreteVisitor2nd();

        objectStructure.accept(concreteVisitor1st);
        System.out.println();
        objectStructure.accept(concreteVisitor2nd);
    }

}
