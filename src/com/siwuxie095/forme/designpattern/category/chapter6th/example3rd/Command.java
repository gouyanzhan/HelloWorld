package com.siwuxie095.forme.designpattern.category.chapter6th.example3rd;

/**
 * 命令
 *
 * @author Jiajing Li
 * @date 2019-10-28 18:17:27
 */
class Command {

    /**
     * 命令持有对接收者的引用
     */
    private Receiver receiver;

    Command(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * 命令执行：让接收者处理命令（接收者的动作被调用）
     */
    void execute() {
        receiver.action();
    }
}
