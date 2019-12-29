package com.siwuxie095.forme.designpattern.category.chapter6th.example5th;

/**
 * @author Jiajing Li
 * @date 2019-10-29 17:12:40
 */
public class Main {

    /**
     * 先用命令模式设计一个简单遥控器，来控制灯的打开
     *
     * 其实这里可以把 Person 给去掉，因为客户的含义即是创建命令的一方，
     * 在 Main 中也是可以创建命令的
     */
    public static void main(String[] args) {
        // 人创建开灯的命令（人有了开灯的想法）
        Person person = new Person();
        Command lightOnCommand = person.createLightOnCommand();
        // 遥控器上的对应插槽预加载好开灯的命令（衔接）
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        remoteControl.setCommand(lightOnCommand);
        // 遥控器上的对应按钮被按下
        remoteControl.buttonWasPressed();
    }

}
