package com.siwuxie095.forme.designpattern.category.chapter10th.example6th;

/**
 * 糖果机
 *
 * @author Jiajing Li
 * @date 2019-11-08 13:23:40
 */
class GumballMachine {

    /**
     * 售罄状态
     */
    private static State soldOutState = new SoldOutState();

    /**
     * 没有投币状态
     */
    private static State noCoinState = new NoCoinState();

    /**
     * 已经投币状态
     */
    private static State hasCoinState = new HasCoinState();

    /**
     * 正在出货状态
     */
    private static State soldState = new SoldState();

    /**
     * 赢家状态
     */
    private static State winnerState = new WinnerState();

    /**
     * 糖果机当前状态
     *
     * 没有糖果机的时候，默认为售罄状态
     */
    private State state = soldOutState;

    /**
     * 糖果数量
     */
    private int count = 0;

    GumballMachine(int count) {

        this.count = count;
        // 创建糖果机，如果有糖果，初始状态设为没有投币
        if (count > 0) {
            state = noCoinState;
        }
    }

    /**
     * 投入硬币的动作委托给当前状态对象处理
     */
    void insertCoin() {
        state.insertCoin(this);
    }

    /**
     * 退回硬币的动作委托给当前状态对象处理
     */
    public void ejectCoin() {
        state.ejectCoin(this);
    }

    /**
     * 转动曲柄的动作委托给当前状态对象处理
     *
     * 注意：不需要在 GumballMachine 中准备一个 dispense() 的动作方法，
     * 因为这只是一个内部的动作，用户不可能直接要求机器发放糖果。
     */
    public void turnCrank() {
        state.turnCrank(this);
        state.dispense(this);
    }

    void setState(State state) {
        this.state = state;
    }

    /**
     * 一个辅助方法用来释放出糖果，并将 count 值减 1
     */
    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    /**
     * 重新填入
     *
     * 售罄后，使用该方法来装填糖果，并更新糖果机的状态
     */
    void refill(int count) {
        this.count = count;
        this.state = noCoinState;
    }

    State getSoldOutState() {
        return soldOutState;
    }

    State getNoCoinState() {
        return noCoinState;
    }

    State getHasCoinState() {
        return hasCoinState;
    }

    State getSoldState() {
        return soldState;
    }

    State getWinnerState() {
        return winnerState;
    }

    int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "remaining count = " + count;
    }
}
