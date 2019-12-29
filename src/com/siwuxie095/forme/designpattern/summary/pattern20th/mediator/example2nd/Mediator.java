package com.siwuxie095.forme.designpattern.summary.pattern20th.mediator.example2nd;

/**
 * 抽象中介者
 *
 * @author Jiajing Li
 * @date 2019-11-11 20:38:12
 */
abstract class Mediator {

    /**
     * 注册
     */
    abstract void register(Colleague colleague);

    /**
     * 转发
     */
    abstract void relay(Colleague colleague);

}
