package com.siwuxie095.forme.designpattern.category.chapter7th.example6th;

/**
 * CD 播放器
 *
 * @author Jiajing Li
 * @date 2019-11-04 20:15:10
 */
class CdPlayer {

    void on() {
        System.out.println("CD 播放器打开");
    }

    void off() {
        System.out.println("CD 播放器关闭");
    }

    void eject() {
        System.out.println("CD 播放器弹出 CD");
    }

    void play() {
        System.out.println("CD 播放器播放");
    }

    void pause() {
        System.out.println("CD 播放器暂停");
    }

    void stop() {
        System.out.println("CD 播放器停止");
    }

}
