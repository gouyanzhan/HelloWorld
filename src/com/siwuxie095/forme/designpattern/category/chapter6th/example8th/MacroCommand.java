package com.siwuxie095.forme.designpattern.category.chapter6th.example8th;

/**
 * 宏命令
 *
 * @author Jiajing Li
 * @date 2019-11-04 13:44:07
 */
class MacroCommand implements Command {

    /**
     * 宏命令中存储一组要执行的命令
     */
    Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    /**
     * 执行命令：执行宏命令中的这组命令
     */
    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    /**
     * 撤销命令：撤销宏命令中的这组命令
     */
    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }
}
