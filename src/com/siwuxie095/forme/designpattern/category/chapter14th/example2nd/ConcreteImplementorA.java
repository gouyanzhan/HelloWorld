package com.siwuxie095.forme.designpattern.category.chapter14th.example2nd;

/**
 * 具体实现类 A
 *
 * @author Jiajing Li
 * @date 2019-11-11 15:29:46
 */
class ConcreteImplementorA extends Implementor {

    @Override
    void operationImpl() {
        System.out.println(this.getClass().getSimpleName());
    }
}
