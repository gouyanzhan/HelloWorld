package com.siwuxie095.forme.designpattern.summary.pattern9th.facade.example1st;

/**
 * 剧场灯光
 *
 * @author Jiajing Li
 * @date 2019-11-04 20:16:04
 */
class TheaterLight {

    void on() {
        System.out.println("剧场灯光打开");
    }

    void off() {
        System.out.println("剧场灯光关闭");
    }

    void dim(int lightness) {
        System.out.println(String.format("剧场灯光调暗到亮度 %s", lightness));
    }

}
