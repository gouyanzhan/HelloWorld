package com.siwuxie095.forme.designpattern.category.chapter3rd.example3rd;

/**
 * 具体装饰者 B
 *
 * @author Jiajing Li
 * @date 2019-10-10 10:40:05
 */
class ConcreteDecoratorB extends Decorator {

    /*
     * 同样的，ConcreteDecoratorB 也继承了 Decorator 中的 wrappedComponent。
     */

    /**
     * 装饰者可以扩展 Component 的状态。
     */
    Object newState;

    @Override
    public void methodA() {

    }

    @Override
    public void methodB() {

    }

    /**
     * 装饰者可以加上新的方法。新行为是通过在旧行为前面或后面做一些计算（或操作）来添加的。
     */
    public void otherMethod() {

    }
}
