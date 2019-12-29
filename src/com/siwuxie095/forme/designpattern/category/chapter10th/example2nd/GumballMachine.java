package com.siwuxie095.forme.designpattern.category.chapter10th.example2nd;

/**
 * 糖果机
 *
 * @author Jiajing Li
 * @date 2019-11-07 22:45:06
 */
class GumballMachine {


    /**
     * 售罄状态
     */
    private static int SOLD_OUT = 0;

    /**
     * 没有投币状态
     */
    private static int NO_COIN = 1;

    /**
     * 已经投币状态
     */
    private static int HAS_COIN = 2;

    /**
     * 正在出货状态
     */
    private static int SOLD = 3;

    /**
     * 赢家状态
     */
    private static int WINNER = 4;

    /**
     * 糖果机当前状态
     *
     * 没有糖果机的时候，默认为售罄状态
     */
    private int state = SOLD_OUT;

    /**
     * 糖果数量
     */
    private int count = 0;

    GumballMachine(int count) {
        this.count = count;
        // 创建糖果机，如果有糖果，初始状态设为没有投币
        if (count > 0) {
            state = NO_COIN;
        }
    }

    /**
     * 投入硬币
     */
    void insertCoin() {
        if (state == HAS_COIN) {
            System.out.println("You can't insert anther coin");
        } else if (state == NO_COIN) {
            state = HAS_COIN;
            System.out.println("You inserted a coin");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't insert a coin, the machine is sold out");
        } else if (state == SOLD) {
            System.out.println("Please wait, we're already giving you a gumball");
        }
    }

    /**
     * 退回硬币
     */
    void ejectCoin() {
        if (state == HAS_COIN) {
            System.out.println("Coin returned");
            state = NO_COIN;
        } else if (state == NO_COIN) {
            System.out.println("You haven't inserted a coin");
        } else if (state == SOLD) {
            System.out.println("Sorry, you already turned the crank");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't eject, you haven't inserted a coin yet");
        }
    }

    /**
     * 转动曲柄
     */
    void turnCrank() {
        if (state == SOLD) {
            System.out.println("Turning twice doesn't get you another gumball");
        } else if (state == NO_COIN) {
            System.out.println("You turned but there's no coin");
        } else if (state == SOLD_OUT) {
            System.out.println("You turned, but there are no gumballs");
        } else if (state == HAS_COIN) {
            System.out.println("you turned ...");
            state = SOLD;
            dispense();
        }
    }

    /**
     * 发放糖果（出货）
     */
    private void dispense() {
        if (state == SOLD) {
            System.out.println("A gumball comes rolling out the slot");
            count = count - 1;
            if (count == 0) {
                System.out.println("Oops, out of gumballs");
                state = SOLD_OUT;
            } else {
                state = NO_COIN;
            }
        } else if (state == NO_COIN) {
            System.out.println("You need pay first");
        } else if (state == SOLD_OUT) {
            System.out.println("No gumball dispensed");
        } else if (state == HAS_COIN) {
            System.out.println("No gumball dispensed");
        }
    }

    @Override
    public String toString() {
        return "current state = " + state + ", remaining count = " + count;
    }

    /**
     * 重新填入
     *
     * 售罄后，使用该方法来装填糖果，并更新糖果机的状态
     */
    void refill(int count) {
        this.count = count;
        this.state = NO_COIN;
    }
}
