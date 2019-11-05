package com.siwuxie095.forme.designpattern.category.chapter7th.example6th;

/**
 * 投影仪
 *
 * @author Jiajing Li
 * @date 2019-11-04 20:20:49
 */
class Projector {

    private CdPlayer cdPlayer;

    private DvdPlayer dvdPlayer;

    void on() {
        System.out.println("投影仪打开");
    }

    void off() {
        System.out.println("投影仪关闭");
    }

    void setInput(CdPlayer cdPlayer) {
        this.cdPlayer = cdPlayer;
        System.out.println("投影仪输入切换到 CD");
    }

    void setInput(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
        System.out.println("投影仪输入切换到 DVD");
    }

    void tvMode() {
        System.out.println("投影仪设为 TV 模式");
    }

    void wideScreenMode() {
        System.out.println("投影仪设为宽屏模式");
    }

}
