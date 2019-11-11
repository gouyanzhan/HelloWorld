package com.siwuxie095.forme.designpattern.category.chapter14th.example18th;

/**
 * 具体元素 A
 *
 * @author Jiajing Li
 * @date 2019-11-11 23:45:32
 */
class ConcreteElementA extends Element {

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }

    String operation() {
        return "具体元素 A 的操作";
    }
}
