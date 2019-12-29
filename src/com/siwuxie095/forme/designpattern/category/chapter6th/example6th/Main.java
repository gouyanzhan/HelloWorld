package com.siwuxie095.forme.designpattern.category.chapter6th.example6th;

/**
 * @author Jiajing Li
 * @date 2019-10-27 17:25:55
 */
public class Main {

    /**
     * 实现遥控器
     *
     * 遥控器一共有 7 个插槽，每个插槽都具备了 "开" 和 "关" 按钮，
     * 可以通过如下方式将命令指定给遥控器（绑定）：
     * onCommands[slot] = onCommand;
     * offCommands[slot] = offCommand;
     *
     * 命令绑定完毕后，遥控器并不能区分家电，除了在按下按钮时，调用
     * 对应命令对象的 execute() 方法之外，它什么都不知道。
     *
     * 即 将遥控器的每个插槽，对应到一个命令这样就让遥控器变成 "调
     * 用者"。当按下按钮时，相应命令对象的 execute() 方法就被调用，
     * 其结果就是，接收者（例如：等、电扇、音响等）的动作被调用。
     *
     *
     * 为了不用每次都检查是否某个插槽都加载了命令，如下：
     * void onButtonWasPushed(int slot) {
     *    if (null != onCommands[slot]) {
     *       onCommands[slot].execute();
     *    }
     * }
     * 需要实现一个不做事情的命令，即 NoCommand，在初始化时加载
     * 到遥控器上。
     *
     * 这样一来，在 RemoteControl 构造器中，将每个插槽都预先指
     * 定成 NoCommand 对象，以便确定每个插槽永远都有命令对象。
     *
     *
     * NoCommand 对象是一个空对象（null object）的例子。当你不想
     * 返回一个有意义的对象时，空对象就很有用。客户也可以将处理 null
     * 的责任转移给空对象。举例来说，遥控器不可能一出厂就设置了有意义
     * 的命令对象，所以提供了 NoCommand 对象作为代用品，当调用它的
     * execute() 方法时，这种对象什么事情都不做。
     *
     * 在许多设计模式中，都会看到空对象的使用。甚至有些时候，空对象
     * 本身也被视为是一种设计模式。
     *
     *
     * 对于遥控器 API 整体来说
     *
     * 主要设计目标是让遥控器代码尽可能地简单，这样一来，新的厂商类
     * 一旦出现，遥控器并不需要随之修改。因此采用了命令模式，从逻辑
     * 上将遥控器的类和厂商的类解耦。这将降低遥控器的生产成本，并大
     * 大减少未来维护时所需的费用。
     * （1）RemoteLoader 创建许多命令对象，然后将其加载到遥控器的
     * 插槽中。每个命令对象都封装了某个家电自动化装置的一项请求。
     * （2）RemoteControl 管理一组命令对象，每个按钮都有一个命令
     * 对象。每当按下按钮，就调用相应的 xxButtonWasPushed() 方法，
     * 间接造成该命令的 execute() 方法被调用。
     * （3）所有的遥控器命令都实现 Command 接口，此接口中包含了一
     * 个方法，也就是 execute()，命令封装了某个特定厂商类的一组动
     * 作，遥控器可以通过调用 execute() 方法，执行这些动作。
     * （4）利用 Command 接口，每个动作都被实现成一个简单的命令对
     * 象。命令对象持有对一个厂商类的实例的引用，并实现 execute()
     * 方法。这个方法会调用厂商类实例的一个或多个方法，完成特定的行
     * 为。
     * （5）厂商类被用来控制特定的家电自动化装置。
     *
     *
     *
     *
     *
     *
     *
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
         */
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
    }

}
