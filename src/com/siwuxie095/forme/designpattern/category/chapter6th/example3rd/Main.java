package com.siwuxie095.forme.designpattern.category.chapter6th.example3rd;

/**
 * @author Jiajing Li
 * @date 2019-10-28 18:26:12
 */
public class Main {

    /**
     * 从餐厅到命令模式
     *
     * （1）客户负责创建命令对象。命令对象包含了接收者上的一个/一组动作。动作和接收者
     * 在命令对象中被绑在一起。即 命令对象持有对接收者的引用，同时接收者的动作被封装在
     * 命令对象的 execute() 方法中。
     * （2）客户在调用者对象上调用 setCommand() 方法，并把它传入命令对象。该命令对象
     * 被储存在其中，以后需要用到。
     * （3）未来的某个时间点，调用者将调用自己的 doCommand() 方法，实际上是调用命令
     * 对象的 execute() 方法。这导致接收者的动作被调用。
     *
     * 注意：
     * 一旦命令被加载到调用者，该命令可以被使用并丢弃，或者可以被保留下来并使用多次。
     */
    public static void main(String[] args) {
        // 客户创建命令，并指定接收者
        Client client = new Client();
        Command command = client.createCommand();

        // 调用者设置命令
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        // 调用者让命令执行
        invoker.doCommand();
    }

}
