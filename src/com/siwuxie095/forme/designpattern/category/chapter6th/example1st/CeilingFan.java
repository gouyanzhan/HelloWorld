package com.siwuxie095.forme.designpattern.category.chapter6th.example1st;

/**
 * 吊扇
 *
 * @author Jiajing Li
 * @date 2019-10-27 15:59:24
 */
class CeilingFan {

    /**
     * 速度
     */
    private int speed;

    private static final int HIGH = 5;

    private static final int MEDIUM = 3;

    private static final int LOW = 1;

    private static final int OFF = 0;

    /**
     * 高速
     */
    void high() {
        speed = HIGH;
        System.out.println("将吊扇设为高速");
    }

    /**
     * 中速
     */
    void medium() {
        speed = MEDIUM;
        System.out.println("将吊扇设为中速");
    }

    /**
     * 低速
     */
    void low() {
        speed = LOW;
        System.out.println("将吊扇设为低速");
    }

    /**
     * 关闭
     */
    void off() {
        speed = OFF;
        System.out.println("将吊扇设为关闭");
    }

    int getSpeed() {
        return speed;
    }

}
