package com.siwuxie095.forme.designpattern.category.chapter6th.example4th;

/**
 * @author Jiajing Li
 * @date 2019-10-29 09:53:01
 */
public class Main {

    /**
     * 命令模式
     *
     * 将 "请求" 封装成对象，以便使用不同的请求、队列或者日志来参数化其他对象，命令
     * 模式也支持可撤销的操作。
     *
     *
     * 释义：
     * （1）请求中包含了接收者和一组动作，被封装成了命令。
     * （2）以便使用不同的请求来参数化其他对象，即 将命令对象作为调用者的参数（成员），
     * 因为所有的命令实现了同样的接口，所以不同的请求都可以来做这种参数化，其实是被
     * 调用者参数化。（PS：这里是指广义的接口，下同）
     * （3）队列和日志，同理。
     *
     *
     *
     * 从定义可知，一个命令对象通过在特定接收者上绑定一组动作来封装一个请求。要达到
     * 这一点，命令对象将动作和接收者包进对象中。这个对象只暴露出一个 execute()
     * 方法，当此方法被调用的时候，接收者就会进行这些动作。从外面来看，其他对象不知
     * 道究竟哪个接收者进行了哪些动作，只知道如果调用 execute() 方法，请求的目的
     * 就能达到。
     *
     * 利用命令来参数化对象的例子：
     * （1）回到餐厅，一整天下来，女招待参数化许多订单。
     * （2）回到遥控器，先用一个 "打开电灯" 命令加载按钮插槽，稍后又将命令替换成另
     * 一个 "打开车库门" 命令。和女招待一样，遥控器插槽根本不在乎所拥有的是什么命令
     * 对象，只要该命令对象实现了 Command 接口就可以了。
     *
     * 所谓利用利用命令来参数化对象，其实就是将命令包装成一个对象作为调用者的参数。
     * 即 命令被调用者参数化，也即 命令对象成了调用者的参数。此时，就能让命令对象
     * 调用封装请求的方法，即 execute() 方法。
     *
     *
     * 这里还没有说到命令模式来实现 "队列、日志和支持撤销操作"，其实它们是基本命令
     * 模式相当直接的扩展，稍后会说到。而一旦有了足够的基础，也可以轻易的支持所谓的
     * 元命令模式 Meta Command Pattern，它可以创建命令的宏，以便一次执行多个命令。
     *
     *
     *
     * 总体来说
     *
     * （1）Client（客户）：客户负责创建一个 ConcreteCommand，并设置其接收者。
     *
     * （2）Invoker（调用者）：调用者持有一个命令对象，并在某个时间点调用命令对象
     * 的 execute() 方法，将请求付诸实行。
     *
     * （3）Command（命令）：Command 为所有命令声明了一个接口。调用命令对象的
     * execute() 方法，就可以让接收者进行相关的动作。这个接口也具备一个 undo()
     * 方法，可以让接收者进行相关的动作。（两个方法互逆，即 一个执行，一个撤销）
     *
     * （4）ConcreteCommand（具体命令）：ConcreteCommand 定义了动作和接收
     * 者之间的绑定关系。调用者只要调用 execute() 就可以发出请求，然后由
     * ConcreteCommand 调用接收者的一个或多个动作。
     *
     * （5）Receiver（接收者）：接收者知道如何进行必要的工作，实现这个请求。
     * 任何类都可以当接收者。
     */
    public static void main(String[] args) {

        // 客户创建具体命令 A
        Client client = new Client();
        Command concreteCommandA = client.createConcreteCommandA();
        // 调用者设置命令 A、执行命令 A、撤销命令 A
        Invoker invoker = new Invoker();
        invoker.setCommand(concreteCommandA);
        invoker.doCommand();
        invoker.undoCommand();

        System.out.println();

        // 客户创建具体命令 B
        Command concreteCommandB = client.createConcreteCommandB();
        // 调用者设置命令 B、执行命令 B、撤销命令 B
        invoker.setCommand(concreteCommandB);
        invoker.doCommand();
        invoker.undoCommand();

    }

}
