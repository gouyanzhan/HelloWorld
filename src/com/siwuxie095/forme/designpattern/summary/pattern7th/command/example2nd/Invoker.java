package com.siwuxie095.forme.designpattern.summary.pattern7th.command.example2nd;

/**
 * 调用者
 *
 * @author Jiajing Li
 * @date 2019-10-29 09:52:13
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

    /**
     * 调用者让命令撤销
     */
    void undoCommand() {
        command.undo();
    }

}
