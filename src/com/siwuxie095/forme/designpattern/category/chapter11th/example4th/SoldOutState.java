package com.siwuxie095.forme.designpattern.category.chapter11th.example4th;

/**
 * 售罄状态
 *
 * @author Jiajing Li
 * @date 2019-11-08 13:14:14
 */
class SoldOutState implements State {

    /**
     * 持有对糖果机的引用
     *
     * 当执行对应动作后，糖果机的状态可能会修改
     */
    private transient GumballMachine gumballMachine;

    SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You can't insert a coin, the machine is sold out");
    }

    @Override
    public void ejectCoin() {
        System.out.println("You can't eject, you haven't inserted a coin yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
