package com.siwuxie095.forme.designpattern.category.chapter7th.example5th;

/**
 * 调音器
 *
 * @author Jiajing Li
 * @date 2019-11-04 20:22:18
 */
class Tuner {

    void on() {
        System.out.println("调音器打开");
    }

    void off() {
        System.out.println("调音器关闭");
    }

    /**
     * 设置调幅
     */
    void setAm() {
        System.out.println("调音器设置调幅");
    }

    /**
     * 设置调频
     */
    void setFm() {
        System.out.println("调音器设置调频");
    }

    /**
     * 设置频率
     */
    void setFrequency(int frequency) {
        System.out.println(String.format("调音器设置频率为 %s", frequency));
    }

}
