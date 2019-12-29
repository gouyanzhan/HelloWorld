package com.siwuxie095.forme.designpattern.summary.pattern15th.bridge.example2nd;

/**
 * 具体实现类 B
 *
 * @author Jiajing Li
 * @date 2019-11-11 15:29:46
 */
class ConcreteImplementorB extends Implementor {

    @Override
    void operationImpl() {
        System.out.println(this.getClass().getSimpleName());
    }
}
