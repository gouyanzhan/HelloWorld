package com.siwuxie095.forme.designpattern.category.chapter10th.example5th;

import java.util.Random;

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
    private GumballMachine gumballMachine;

    /**
     * 随机数产生器
     */
    private Random randomWinner = new Random(System.currentTimeMillis());

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
        // 10% 的机率
        int winner = randomWinner.nextInt(10);
        // 如果赢了，且有足够的糖果，进入赢家状态，否则进入正在出货状态
        if (winner == 0 && gumballMachine.getCount() > 1) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
