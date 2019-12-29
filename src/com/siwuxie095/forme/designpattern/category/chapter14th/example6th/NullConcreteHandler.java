package com.siwuxie095.forme.designpattern.category.chapter14th.example6th;

/**
 * 空具体处理器
 *
 * @author Jiajing Li
 * @date 2019-11-11 16:52:08
 */
class NullConcreteHandler extends Handler {

    @Override
    void handleRequest(String request) {
        System.out.println("空具体处理器：什么都不做");
    }
}
