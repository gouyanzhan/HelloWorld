package com.siwuxie095.forme.designpattern.category.chapter10th.example5th;

/**
 * @author Jiajing Li
 * @date 2019-11-08 12:57:38
 */
public class Main {

    /**
     * 为糖果机加入赢家模式
     *
     * 即 当曲柄被转动时，有 10% 机率掉下来的是两颗糖果，也就是多送一颗。
     *
     *
     * 疑问与解答
     *
     * 问：
     * 为什么需要 WinnerState？为什么不直接在 SoldState 中发放两颗糖果？
     * 答：
     * 这是一个好问题。这两个状态几乎一样，唯一的差别在于，WinnerState 会
     * 发放两颗糖果。你当然可以将发放两颗糖果的代码放在 SoldState 中，当然
     * 这么做有缺点，因为你等于是将两个状态用一个状态类来代表。这样做你牺牲
     * 了状态类的清晰易懂来减少一些冗余代码。你也应该考虑到 "一个类，一个责
     * 任" 的设计原则。将 WinnerState 状态的责任放进 SoldState 状态中，
     * 等于是让 SoldState 状态具有两个责任。那么促销方案结束之后或者赢家的
     * 机率改变之后，你又该怎么办？所以，这必须用你的智慧来做折衷。
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
