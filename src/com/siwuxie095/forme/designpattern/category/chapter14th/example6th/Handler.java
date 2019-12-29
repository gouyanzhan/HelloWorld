package com.siwuxie095.forme.designpattern.category.chapter14th.example6th;

/**
 * 处理器
 *
 * @author Jiajing Li
 * @date 2019-11-11 16:49:11
 */
abstract class Handler {

    private Handler successor;

    Handler getSuccessor() {
        return successor;
    }

    void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    abstract void handleRequest(String request);
}
