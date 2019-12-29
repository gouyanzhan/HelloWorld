package com.siwuxie095.forme.designpattern.category.chapter14th.example5th;

/**
 * 邮件处理器
 *
 * @author Jiajing Li
 * @date 2019-11-11 16:28:07
 */
abstract class Handler {

    /**
     * 后继处理器
     */
    private Handler successor;

    Handler getSuccessor() {
        return successor;
    }

    void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    abstract void handleRequest(String request);
}
