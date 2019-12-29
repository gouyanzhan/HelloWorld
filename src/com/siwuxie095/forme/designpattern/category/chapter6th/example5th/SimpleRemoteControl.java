package com.siwuxie095.forme.designpattern.category.chapter6th.example5th;

/**
 * 简单遥控器（调用者）
 *
 * @author Jiajing Li
 * @date 2019-10-29 17:06:07
 */
class SimpleRemoteControl {

    /**
     * 有一个插槽持有命令，而这个命令控制一个家电
     */
    private Command slot;

    /**
     * 设置插槽控制的命令。如果这段代码的客户想要
     * 改变遥控器按钮的行为，可以多次调用这个方法
     */
    void setCommand(Command command) {
        slot = command;
    }

    /**
     * 当按下按钮时，这个方法就会被调用，使得当
     * 前命令衔接插槽，调用它的 execute() 方法
     */
    void buttonWasPressed() {
        slot.execute();
    }



}
