package com.siwuxie095.forme.designpattern.category.chapter10th.example2nd;

/**
 * @author Jiajing Li
 * @date 2019-11-07 23:09:21
 */
public class Main {

    /**
     * 需求变更来了
     *
     * 现在想将 "购买糖果" 变成是一个游戏，以增加销售量。即 当曲柄被转动时，
     * 有 10% 机率掉下来的是两颗糖果，也就是多送一颗。
     *
     * 显然，使用一种考虑周详的方法学写糖果机的代码，并不意味着这份代码就容
     * 易扩展。
     *
     * 首先，必须加上一个新的状态，称为 "赢家"。然后必须在每个方法中加入新
     * 的条件判断来处理 "赢家" 状态，很是麻烦。turnCrank() 尤其会变的一
     * 团乱，因为你必须加上代码来检查目前的顾客是否是赢家，然后再决定是切换
     * 到赢家状态还是正在出货状态。
     *
     * 而且如果这么做，就会有如下问题：
     * （1）代码没有遵守开放-关闭原则。
     * （2）设计不符合面向对象。
     * （3）状态转换被埋藏在条件语句中，所以不明显。
     * （4）没有把会改变的部分包装起来。
     * （5）未来加入的代码很有可能会导致 bug。
     *
     * 所以需要重构代码，以便能更容易地维护和修改。
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
