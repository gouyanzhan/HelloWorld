package com.siwuxie095.forme.designpattern.category.chapter14th.example6th;

/**
 * 一号具体处理器
 *
 * @author Jiajing Li
 * @date 2019-11-11 16:51:28
 */
class ConcreteHandler1st extends Handler {

    ConcreteHandler1st() {
        setSuccessor(new NullConcreteHandler());
    }

    @Override
    void handleRequest(String request) {
        if ("one".equals(request)) {
            System.out.println("一号具体处理器：处理了该请求");
        } else {
            getSuccessor().handleRequest(request);
        }
    }
}
