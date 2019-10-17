package com.siwuxie095.forme.designpattern.summary.pattern5th.abstractfactory.example2nd;

/**
 * 抽象工厂
 *
 * @author Jiajing Li
 * @date 2019-10-14 17:22:25
 */
interface AbstractFactory {

    /**
     * 创建产品 A
     */
    AbstractProductA createProductA();

    /**
     * 创建产品 B
     */
    AbstractProductB createProductB();

}
