package com.siwuxie095.forme.designpattern.category.chapter6th.example4th;

/**
 * 客户
 *
 * @author Jiajing Li
 * @date 2019-10-29:51:54
 */
class Client {

    /**
     * 客户创建具体命令 A，并设置接收者
     */
    Command createConcreteCommandA() {
        return new ConcreteCommandA(new Receiver());
    }

    /**
     * 客户创建具体命令 B，并设置接收者
     */
    Command createConcreteCommandB() {
        return new ConcreteCommandB(new Receiver());
    }

}
