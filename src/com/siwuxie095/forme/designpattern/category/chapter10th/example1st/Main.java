package com.siwuxie095.forme.designpattern.category.chapter10th.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-07 23:09:21
 */
public class Main {

    /**
     * 状态模式：事物的状态
     *
     * 基本常识：策略模式和状态模式是双胞胎，在出生时才分开。已经知道，
     * 策略模式是围绕可以互换的算法来创建成功业务的。然而，状态走的是
     * 更崇高的路，它通过改变对象内部的状态来帮助对象控制自己的行为。
     *
     * 现在有一个糖果机，其内部状态是这样流转的：
     * （1）没有投币状态，你投入硬币后，进入已经投币状态
     * （2）已经投币状态，你退回硬币后，进入没有投币状态
     * （3）已经投币状态，你转动曲柄后，进入正在出货状态
     * （4）正在出货状态，出货后，如果糖果数量为 0，进入售罄状态
     * （5）正在出货状态，出货后，如果糖果数量不为 0，进入没有投币状态
     *
     * 即
     * 一共有 4 个状态：没有投币、已经投币、正在出货、售罄。对应的，也有
     * 4 个动作：投入硬币、退回硬币、转动曲柄、发放糖果。其中前 3 个动作
     * 是外部动作，由外部来调用，而第 4 个发放糖果，则是内部动作，糖果机
     * 自己调用自己。
     *
     * 现在创建一个类 GumballMachine，其作用就像是一个状态机。对每个动
     * 作都创建了一个对应的方法，这些方法利用条件语句来决定在每个状态内什
     * 么行为是恰当的。
     *
     * 这里讨论的是一个通用的技巧：如何对对象内的状态建模 -- 通过创建一个
     * 实例变量来持有状态值，并在方法内书写条件代码来处理不同状态。
     *
     * 从以下的内部测试可以感觉到，它像是使用思虑周密的方法学构造的牢不可破
     * 的设计。
     */
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertCoin();
        gumballMachine.ejectCoin();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.ejectCoin();
        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertCoin();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
    }

}
