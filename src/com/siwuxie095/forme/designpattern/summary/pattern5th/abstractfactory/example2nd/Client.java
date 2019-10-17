package com.siwuxie095.forme.designpattern.summary.pattern5th.abstractfactory.example2nd;

/**
 * 客户
 *
 * @author Jiajing Li
 * @date 2019-10-14 17:26:27
 */
public class Client {

    /*
     * 产品 A 和 产品 B 共通组成产品家族。每一个具体工厂
     * 都能生产一整组的产品。
     */

    /**
     * 产品 A
     */
    AbstractProductA productA;
    /**
     * 产品 B
     */
    AbstractProductB productB;

    /**
     * 工厂
     */
    AbstractFactory factory;

    public Client(AbstractFactory factory) {
        this.factory = factory;
    }

    void foo() {
        productA = factory.createProductA();
        productB = factory.createProductB();
        // do something ...
    }


}
