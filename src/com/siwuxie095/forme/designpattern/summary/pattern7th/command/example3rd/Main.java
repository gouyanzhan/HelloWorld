package com.siwuxie095.forme.designpattern.summary.pattern7th.command.example3rd;

/**
 * @author Jiajing Li
 * @date 2019-10-27 17:25:55
 */
public class Main {

    public static void main(String[] args) {

        /*
         * 创建并加载遥控器
         */
        RemoteControl remoteControl = RemoteLoader.createRemoteControl();

        /*
         * 打印遥控器
         */
        System.out.println(remoteControl);

        /*
         * 使用遥控器
         *
         * 灯的开、关、撤销
         * 吊扇的开、关、撤销
         */
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();

        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.undoButtonWasPushed();
    }

}
