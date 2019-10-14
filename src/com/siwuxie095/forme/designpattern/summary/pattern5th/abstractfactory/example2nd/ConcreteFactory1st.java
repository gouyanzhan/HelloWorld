package com.siwuxie095.forme.designpattern.summary.pattern5th.abstractfactory.example2nd;

/**
 * 一号具体工厂
 *
 * @author Jiajing Li
 * @date 2019-10-14 17:24:04
 */
class ConcreteFactory1st implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1st();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1st();
    }
}
