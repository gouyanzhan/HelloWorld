package com.siwuxie095.forme.designpattern.category.chapter10th.example6th;

/**
 * 没有投币状态
 *
 * @author Jiajing Li
 * @date 2019-11-08 13:14:59
 */
class NoCoinState implements State {

    @Override
    public void insertCoin(GumballMachine gumballMachine) {
        System.out.println("You inserted a coin");
        gumballMachine.setState(gumballMachine.getHasCoinState());
    }

    @Override
    public void ejectCoin(GumballMachine gumballMachine) {
        System.out.println("You haven't inserted a coin");
    }

    @Override
    public void turnCrank(GumballMachine gumballMachine) {
        System.out.println("You turned, but there's no coin");
    }

    @Override
    public void dispense(GumballMachine gumballMachine) {
        System.out.println("You need to pay first");
    }
}
