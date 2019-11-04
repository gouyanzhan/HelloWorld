package com.siwuxie095.forme.designpattern.category.chapter6th.example4th;

/**
 * 具体命令 A
 *
 * @author Jiajing Li
 * @date 2019-10-29 09:58:29
 */
class ConcreteCommandA extends Command {

    /**
     * 命令持有对接收者的引用
     *
     * 注意：如果接收者之间具有继承关系或者只有一个接收者，
     * 那么接收者也可以定义在超类中
     */
    private Receiver receiver;


    ConcreteCommandA(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    void execute() {
        System.out.println("让接收者执行具体命令 A：");
        receiver.actionPositively();
    }

    @Override
    void undo() {
        System.out.println("让接收者撤销具体命令 A：");
        receiver.actionNegatively();
    }
}
