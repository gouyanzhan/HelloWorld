package com.siwuxie095.forme.designpattern.category.chapter6th.example3rd;

/**
 * 调用者
 *
 * @author Jiajing Li
 * @date 2019-10-28 18:17:02
 */
class Invoker {

    /**
     * 调用者持有对命令的引用
     */
    private Command command;

    /**
     * 调用者设置命令
     */
    void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 调用者让命令执行
     */
    void doCommand() {
        command.execute();
    }

}
