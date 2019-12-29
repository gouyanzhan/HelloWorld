package com.siwuxie095.forme.designpattern.category.chapter11th.example4th;

/**
 * 已经投币状态
 *
 * @author Jiajing Li
 * @date 2019-11-08 13:15:36
 */
class HasCoinState implements State {

    /**
     * 持有对糖果机的引用
     *
     * 当执行对应动作后，糖果机的状态可能会修改
     */
    private transient GumballMachine gumballMachine;

    HasCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You can't insert another coin");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Coin returned");
        gumballMachine.setState(gumballMachine.getNoCoinState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
