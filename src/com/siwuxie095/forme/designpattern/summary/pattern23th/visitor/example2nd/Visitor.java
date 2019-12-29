package com.siwuxie095.forme.designpattern.summary.pattern23th.visitor.example2nd;

/**
 * 访问者
 *
 * @author Jiajing Li
 * @date 2019-11-11 23:44:44
 */
abstract class Visitor {

    abstract void visit(ConcreteElementA concreteElementA);

    abstract void visit(ConcreteElementB concreteElementB);

}
