package com.siwuxie095.forme.designpattern.summary.pattern9th.facade.example1st;

/**
 * DVD 播放器
 *
 * @author Jiajing Li
 * @date 2019-11-04 20:15:30
 */
class DvdPlayer {

    void on() {
        System.out.println("DVD 播放器打开");
    }

    void off() {
        System.out.println("DVD 播放器关闭");
    }

    void eject() {
        System.out.println("DVD 播放器弹出 DVD");
    }

    void play() {
        System.out.println("DVD 播放器播放");
    }

    void pause() {
        System.out.println("DVD 播放器暂停");
    }

    void stop() {
        System.out.println("DVD 播放器停止");
    }

    void setSurroundAudio() {
        System.out.println("DVD 播放器设为环绕音频");
    }

    void setTwoChannelAudio() {
        System.out.println("DVD 播放器设为双声道音频");
    }

}
