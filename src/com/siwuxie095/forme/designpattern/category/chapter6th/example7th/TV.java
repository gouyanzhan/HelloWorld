package com.siwuxie095.forme.designpattern.category.chapter6th.example7th;

/**
 * 电视（接收者）
 *
 * @author Jiajing Li
 * @date 2019-10-29 17:45:58
 */
class TV {

    /**
     * 输入信道
     */
    private int inputChannel;

    /**
     * 音量
     */
    private int volume;

    /**
     * 打开
     */
    void on() {
        System.out.println("将电视打开");
    }

    /**
     * 关闭
     */
    void off() {
        System.out.println("将电视关闭");
    }

    /**
     * 设置输入信道
     */
    void setInputChannel(int inputChannel) {
        this.inputChannel = inputChannel;
        System.out.println(String.format("将电视输入信道设为 %s", inputChannel));
    }

    /**
     * 设置音量
     */
    void setVolume(int volume) {
        this.volume = volume;
        System.out.println(String.format("将电视音量设为 %s", volume));
    }

}
