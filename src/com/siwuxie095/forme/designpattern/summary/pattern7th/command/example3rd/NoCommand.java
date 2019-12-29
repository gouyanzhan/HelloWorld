package com.siwuxie095.forme.designpattern.summary.pattern7th.command.example3rd;

/**
 * 空命令/没有命令
 *
 * @author Jiajing Li
 * @date 2019-11-04 09:54:48
 */
class NoCommand implements Command {

    /**
     * 执行命令：空命令/无命令
     */
    @Override
    public void execute() {

    }

    /**
     * 撤销命令：空命令/无命令
     */
    @Override
    public void undo() {

    }
}
