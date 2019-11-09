package com.siwuxie095.forme.designpattern.summary.pattern14th.proxy.example2nd;

import java.io.Serializable;

/**
 * 状态
 *
 * @author Jiajing Li
 * @date 2019-11-08 13:11:37
 */
interface State extends Serializable {

    /**
     * 投入硬币
     */
    void insertCoin();

    /**
     * 退回硬币
     */
    void ejectCoin();

    /**
     * 转动曲柄
     */
    void turnCrank();

    /**
     * 发放糖果（出货）
     */
    void dispense();
}
