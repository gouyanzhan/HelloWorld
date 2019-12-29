package com.siwuxie095.forme.designpattern.category.chapter10th.example5th;

/**
 * 正在出货状态
 *
 * @author Jiajing Li
 * @date 2019-11-08 13:16:06
 */
class SoldState implements State {

    /**
     * 持有对糖果机的引用
     *
     * 当执行对应动作后，糖果机的状态可能会修改
     */
    private GumballMachine gumballMachine;

    SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoCoinState());
        } else {
            System.out.println("Oops, out of gumball");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
