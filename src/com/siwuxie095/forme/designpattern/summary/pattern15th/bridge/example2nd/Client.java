package com.siwuxie095.forme.designpattern.summary.pattern15th.bridge.example2nd;

/**
 * 客户
 *
 * @author Jiajing Li
 * @date 2019-11-11 15:31:04
 */
public class Client {

    void call() {
        Implementor implementorA = new ConcreteImplementorA();
        Implementor implementorB = new ConcreteImplementorB();

        Abstraction abstractionA = new RefinedAbstraction(implementorA);
        Abstraction abstractionB = new RefinedAbstraction(implementorB);

        abstractionA.operation();
        abstractionB.operation();

    }

}
