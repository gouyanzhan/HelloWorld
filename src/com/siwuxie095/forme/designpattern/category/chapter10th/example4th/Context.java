package com.siwuxie095.forme.designpattern.category.chapter10th.example4th;

/**
 * 上下文
 *
 * @author Jiajing Li
 * @date 2019-11-08 14:24:52
 */
class Context {

    /*
     * Context（上下文）是一个类，它可以拥有一些内部状态。
     */


    /**
     * 具体状态 A
     */
    private State concreteStateA;

    /**
     * 具体状态 B
     */
    private State concreteStateB;

    /**
     * 当前状态
     */
    private State state;

    Context() {
        concreteStateA = new ConcreteStateA(this);
        concreteStateB = new ConcreteStateB(this);

        state = concreteStateA;
    }

    /**
     * 不管是在什么时候，只要有人调用 Context 的 request() 方法，
     * 它就会委托到状态来处理。
     */
    void request() {
        state.handle();
    }

    void setState(State state) {
        this.state = state;
    }

    State getConcreteStateA() {
        return concreteStateA;
    }

    State getConcreteStateB() {
        return concreteStateB;
    }
}
