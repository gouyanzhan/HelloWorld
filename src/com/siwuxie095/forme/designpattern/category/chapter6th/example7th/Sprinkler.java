package com.siwuxie095.forme.designpattern.category.chapter6th.example7th;

/**
 * 洒水器（接收者）
 *
 * @author Jiajing Li
 * @date 2019-10-29 17:45:21
 */
class Sprinkler {

    /**
     * 打开水源
     */
    void waterOn() {
        System.out.println("将洒水器的水源打开");
    }

    /**
     * 关闭水源
     */
    void waterOff() {
        System.out.println("将洒水器的水源关闭");
    }

}
