package com.siwuxie095.forme.designpattern.category.chapter10th.example6th;

/**
 * 售罄状态
 *
 * @author Jiajing Li
 * @date 2019-11-08 13:14:14
 */
class SoldOutState implements State {

    @Override
    public void insertCoin(GumballMachine gumballMachine) {
        System.out.println("You can't insert a coin, the machine is sold out");
    }

    @Override
    public void ejectCoin(GumballMachine gumballMachine) {
        System.out.println("You can't eject, you haven't inserted a coin yet");
    }

    @Override
    public void turnCrank(GumballMachine gumballMachine) {
        System.out.println("You turned, but there are no gumballs");
    }

    @Override
    public void dispense(GumballMachine gumballMachine) {
        System.out.println("No gumball dispensed");
    }
}
