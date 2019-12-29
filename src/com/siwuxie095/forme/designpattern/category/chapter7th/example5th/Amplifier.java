package com.siwuxie095.forme.designpattern.category.chapter7th.example5th;

/**
 * 功放
 *
 * @author Jiajing Li
 * @date 2019-11-04 20:12:16
 */
class Amplifier {

    private Tuner tuner;

    private CdPlayer cdPlayer;

    private DvdPlayer dvdPlayer;

    void on() {
        System.out.println("功放打开");
    }

    void off() {
        System.out.println("功放关闭");
    }

    void setCd(CdPlayer cdPlayer) {
        this.cdPlayer = cdPlayer;
        System.out.println("功放的输入设置为 CD");
    }

    void setDvd(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
        System.out.println("功放的输入设置为 DVD");
    }

    void setStereoSound() {
        System.out.println("功放设为立体声");
    }

    void setSurroundSound() {
        System.out.println("功放设为环绕声");
    }

    void setTuner(Tuner tuner) {
        this.tuner = tuner;
        System.out.println("功放设置调音器");
    }

    void setVolume(int volume) {
        System.out.println(String.format("功放音量调到 %s", volume));
    }

}
