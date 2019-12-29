package com.siwuxie095.forme.designpattern.category.chapter10th.example6th;

/**
 * 赢家模式
 *
 * @author Jiajing Li
 * @date 2019-11-08 15:30:58
 */
class WinnerState implements State {

    @Override
    public void insertCoin(GumballMachine gumballMachine) {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectCoin(GumballMachine gumballMachine) {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank(GumballMachine gumballMachine) {
        System.out.println("Turning twice doesn't get you another gumball");
    }

    @Override
    public void dispense(GumballMachine gumballMachine) {
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
