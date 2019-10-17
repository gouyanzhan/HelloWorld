package com.siwuxie095.forme.designpattern.summary.pattern5th.abstractfactory.example2nd;

/**
 * 二号具体工厂
 *
 * @author Jiajing Li
 * @date 2019-10-14 17:25:01
 */
class ConcreteFactory2nd implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA2nd();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB2nd();
    }
}
