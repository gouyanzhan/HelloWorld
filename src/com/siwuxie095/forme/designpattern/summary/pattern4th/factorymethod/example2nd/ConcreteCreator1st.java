package com.siwuxie095.forme.designpattern.summary.pattern4th.factorymethod.example2nd;

/**
 * 一号具体创建者
 *
 * @author Jiajing Li
 * @date 2019-10-12 17:32:00
 */
public class ConcreteCreator1st extends Creator {

    /**
     * 具体创建者负责创建一个或多个具体产品，只有
     * 具体创建者知道如何创建这些产品。
     */
    @Override
    Product factoryMethod(String type) {
        return null;
    }
}
