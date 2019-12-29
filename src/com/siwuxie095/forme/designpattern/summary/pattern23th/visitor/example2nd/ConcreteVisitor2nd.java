package com.siwuxie095.forme.designpattern.summary.pattern23th.visitor.example2nd;

/**
 * 二号具体访问者
 *
 * @author Jiajing Li
 * @date 2019-11-11 23:48:12
 */
class ConcreteVisitor2nd extends Visitor {

    @Override
    void visit(ConcreteElementA concreteElementA) {
        System.out.println("二号具体访问者访问：" + concreteElementA.operation());
    }

    @Override
    void visit(ConcreteElementB concreteElementB) {
        System.out.println("二号具体访问者访问：" + concreteElementB.operation());
    }
}
