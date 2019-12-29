package com.siwuxie095.forme.designpattern.summary.pattern20th.mediator.example2nd;

/**
 * 抽象同事
 *
 * @author Jiajing Li
 * @date 2019-11-11 20:38:42
 */
abstract class Colleague {

    protected Mediator mediator;

    void setMedium(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 接收请求
     */
    abstract void receive();

    /**
     * 发送请求
     */
    abstract void send();
}
