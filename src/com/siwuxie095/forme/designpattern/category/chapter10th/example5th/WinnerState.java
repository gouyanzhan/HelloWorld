package com.siwuxie095.forme.designpattern.category.chapter10th.example5th;

/**
 * 赢家模式
 *
 * @author Jiajing Li
 * @date 2019-11-08 15:30:58
 */
class WinnerState implements State {

    /**
     * 持有对糖果机的引用
     *
     * 当执行对应动作后，糖果机的状态可能会修改
     */
    private GumballMachine gumballMachine;

    WinnerState(GumballMachine gumballMachine) {
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
        System.out.println("YOU'RE A WINNER! You get two gumballs for your coin");
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.releaseBall();
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoCoinState());
            } else {
                System.out.println("Oops, out of gumballs");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }
}
