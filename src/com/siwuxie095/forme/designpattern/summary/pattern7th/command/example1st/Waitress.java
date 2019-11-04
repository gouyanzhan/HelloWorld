package com.siwuxie095.forme.designpattern.summary.pattern7th.command.example1st;

/**
 * 女招待（调用者 Invoker）
 *
 * @author Jiajing Li
 * @date 2019-10-28 14:54:40
 */
class Waitress {

    /**
     * 女招待拿订单
     *
     * 相当于 setCommand()
     */
    void takeOrder(Order order) {
        order.orderUp();
    }

}
