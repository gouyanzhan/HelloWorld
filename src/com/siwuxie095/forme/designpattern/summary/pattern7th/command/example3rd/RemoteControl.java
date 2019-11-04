package com.siwuxie095.forme.designpattern.summary.pattern7th.command.example3rd;

/**
 * 遥控器（调用者）
 *
 * @author Jiajing Li
 * @date 2019-10-28 11:13:29
 */
class RemoteControl {

    /*
     * 遥控器要处理 7 个开与关的命令，
     * 使用相应数组记录这些命令
     */

    Command[] onCommands;

    Command[] offCommands;

    /*
     * 记录最后被调用的命令
     */
    Command undoCommand;

    /**
     * 在构造器中只需实例化并初始化这两个开与关的数组
     */
    RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        // 初始化时设置为空命令/无命令
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    /**
     * setCommand() 方法须有 3 个参数，分别是插槽的位置、开的命令、关的命令。
     * 这些命令将记录在开关数组中对应的插槽位置，以供稍后使用。
     */
    void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    /**
     * 当按下开按钮时，硬件就会负责调用对应的方法
     */
    void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    /**
     * 当按下关按钮时，硬件就会负责调用对应的方法
     */
    void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    /**
     * 当按下撤销按钮时，硬件就会负责调用对应的方法
     */
    void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n----- Remote Control -----\n");
        for (int i = 0; i < onCommands.length; i++) {
            buffer.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "   " + offCommands[i].getClass().getName() + "\n");
        }
        return buffer.toString();
    }
}
