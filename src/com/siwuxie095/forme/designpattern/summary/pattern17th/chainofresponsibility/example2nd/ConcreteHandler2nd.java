package com.siwuxie095.forme.designpattern.summary.pattern17th.chainofresponsibility.example2nd;

/**
 * 二号具体处理器
 *
 * @author Jiajing Li
 * @date 2019-11-11 16:51:37
 */
class ConcreteHandler2nd extends Handler {

    ConcreteHandler2nd() {
        setSuccessor(new NullConcreteHandler());
    }

    @Override
    void handleRequest(String request) {
        if ("two".equals(request)) {
            System.out.println("二号具体处理器：处理了该请求");
        } else {
            getSuccessor().handleRequest(request);
        }
    }
}
