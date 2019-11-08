package com.siwuxie095.forme.designpattern.category.chapter10th.example4th;

/**
 * 具体状态 A
 *
 * @author Jiajing Li
 * @date 2019-11-08 14:23:37
 */
class ConcreteStateA implements State {

    /*
     * ConcreteState 具体状态处理来自 Context 的请求。每一个
     * ConcreteState 都提供了它自己对于请求的实现。所以，当
     * Context 改变状态时行为也跟着改变。
     */

    private Context context;

    ConcreteStateA(Context context) {
        this.context = context;
    }

    @Override
    public void handle() {
        System.out.println("ConcreteStateA # handle()");
        context.setState(context.getConcreteStateB());
    }
}
