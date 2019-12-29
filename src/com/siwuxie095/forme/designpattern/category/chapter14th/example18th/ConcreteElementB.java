package com.siwuxie095.forme.designpattern.category.chapter14th.example18th;

/**
 * 具体元素 B
 *
 * @author Jiajing Li
 * @date 2019-11-11 23:45:32
 */
class ConcreteElementB extends Element {

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }

    String operation() {
        return "具体元素 B 的操作";
    }
}
