package com.siwuxie095.forme.designpattern.summary.pattern7th.command.example3rd;

/**
 * 热水浴缸（接收者）
 *
 * @author Jiajing Li
 * @date 2019-10-29 17:40:41
 */
class Hottub {

    /**
     * 温度
     */
    private int temperature;

    /**
     * 循环
     */
    void circulate() {
        System.out.println("将热水浴缸设为循环");
    }

    /**
     * 打开喷射器
     */
    void jetsOn() {
        System.out.println("将热水浴缸的喷射器打开");
    }

    /**
     * 关闭喷射器
     */
    void jetsOff() {
        System.out.println("将热水浴缸的喷射器关闭");
    }

    /**
     * 设置温度
     */
    void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println(String.format("将热水浴缸的温度设为 %s 摄氏度", temperature));
    }

}
