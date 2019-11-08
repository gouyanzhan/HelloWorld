package com.siwuxie095.forme.designpattern.summary.pattern13th.state.example2nd;

/**
 * 具体状态 B
 *
 * @author Jiajing Li
 * @date 2019-11-08 14:24:16
 */
public class ConcreteStateB implements State {

    /*
     * ConcreteState 具体状态处理来自 Context 的请求。每一个
     * ConcreteState 都提供了它自己对于请求的实现。所以，当
     * Context 改变状态时行为也跟着改变。
     */

    private Context context;

    ConcreteStateB(Context context) {
        this.context = context;
    }

    @Override
    public void handle() {
        System.out.println("ConcreteStateB # handle()");
        context.setState(context.getConcreteStateA());
    }
}
