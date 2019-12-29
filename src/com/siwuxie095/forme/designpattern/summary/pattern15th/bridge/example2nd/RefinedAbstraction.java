package com.siwuxie095.forme.designpattern.summary.pattern15th.bridge.example2nd;

/**
 * 扩充抽象类
 *
 * @author Jiajing Li
 * @date 2019-11-11 15:26:12
 */
class RefinedAbstraction extends Abstraction {

    RefinedAbstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    @Override
    void operation() {
        implementor.operationImpl();
    }
}
