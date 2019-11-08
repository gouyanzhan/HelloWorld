package com.siwuxie095.forme.designpattern.category.chapter10th.example6th;

/**
 * 状态
 *
 * @author Jiajing Li
 * @date 2019-11-08 13:11:37
 */
interface State {

    /**
     * 投入硬币
     */
    void insertCoin(GumballMachine gumballMachine);

    /**
     * 退回硬币
     */
    void ejectCoin(GumballMachine gumballMachine);

    /**
     * 转动曲柄
     */
    void turnCrank(GumballMachine gumballMachine);

    /**
     * 发放糖果（出货）
     */
    void dispense(GumballMachine gumballMachine);
}
