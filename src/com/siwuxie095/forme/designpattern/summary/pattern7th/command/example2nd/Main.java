package com.siwuxie095.forme.designpattern.summary.pattern7th.command.example2nd;

/**
 * @author Jiajing Li
 * @date 2019-10-29 09:53:01
 */
public class Main {

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
