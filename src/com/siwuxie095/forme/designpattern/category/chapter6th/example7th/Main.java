package com.siwuxie095.forme.designpattern.category.chapter6th.example7th;

/**
 * @author Jiajing Li
 * @date 2019-10-27 17:25:55
 */
public class Main {

    /**
     * 为遥控器加上撤销功能
     *
     * 遥控器上还有一个整体的撤销按钮，需要逐步为遥控器实现撤销命令。
     *
     * 举例说明撤销：现在灯是关闭的，然后按下遥控器上的开启按钮，灯就打开了。
     * 又按下了撤销按钮，那么上一个动作将被倒转，即 灯就关闭了。
     *
     * 当命令支持撤销时，该命令就必须提供和 execute() 方法相反的 undo()
     * 方法。不管 execute() 刚才做什么，undo() 都会倒转过来。这么一来，
     * 在各个命令中加入 undo() 之前，必须先在 Command 接口中加入 undo()
     * 方法。
     *
     * 要加上对撤销按钮的支持，也必须对遥控器做一些小修改。打算这么做：
     * 加入一个新的实例变量，用来追踪最后被调用的命令，然后不管何时撤销按钮
     * 被按下，都可以取出这个命令并调用它的 undo() 方法。
     *
     *
     * 对于灯而言，只有开和关，撤销的实现很容易。但是通常想要实现撤销的功能，
     * 需要记录一些状态。比如说吊扇，吊扇允许有多种转动速度，当然也允许被关
     * 闭。就可以在命令中用 prevSpeed 记录前一个速度。
     */
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
