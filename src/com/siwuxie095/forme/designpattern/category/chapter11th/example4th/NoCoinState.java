package com.siwuxie095.forme.designpattern.category.chapter11th.example4th;

/**
 * 没有投币状态
 *
 * @author Jiajing Li
 * @date 2019-11-08 13:14:59
 */
class NoCoinState implements State {

    /**
     * 持有对糖果机的引用
     *
     * 当执行对应动作后，糖果机的状态可能会修改
     */
    private transient GumballMachine gumballMachine;

    NoCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You inserted a coin");
        gumballMachine.setState(gumballMachine.getHasCoinState());
    }

    @Override
    public void ejectCoin() {
        System.out.println("You haven't inserted a coin");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there's no coin");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }
}
