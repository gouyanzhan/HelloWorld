package com.siwuxie095.forme.designpattern.summary.pattern7th.command.example3rd;

/**
 * 音响（接收者）
 *
 * @author Jiajing Li
 * @date 2019-10-29 17:45:38
 */
class Stereo {

    /**
     * 音量
     */
    private int volume;

    /**
     * 打开
     */
    void on() {
        System.out.println("将音响打开");
    }

    /**
     * 关闭
     */
    void off() {
        System.out.println("将音响关闭");
    }

    /**
     * 设为 CD 模式
     */
    void setCd() {
        System.out.println("将音响设为 CD 模式");
    }

    /**
     * 设为 DVD 模式
     */
    void setDvd() {
        System.out.println("将音响设为 DVD 模式");
    }

    /**
     * 设为收音机模式
     */
    void setRadio() {
        System.out.println("将音响设为收音机模式");
    }

    /**
     * 设置音量
     */
    void setVolume(int volume) {
        this.volume = volume;
        System.out.println(String.format("将音响的音量设为 %s", volume));
    }

}
