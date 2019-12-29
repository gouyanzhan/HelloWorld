package com.siwuxie095.forme.designpattern.summary.pattern15th.bridge.example1st;

/**
 * 夏普电视
 *
 * @author Jiajing Li
 * @date 2019-11-11 14:22:14
 */
class SharpTV extends TV {

    @Override
    void on() {
        System.out.println("打开夏普电视");
    }

    @Override
    void off() {
        System.out.println("关闭夏普电视");
    }

    @Override
    void tuneChannel(String remoteControlName, int channel) {
        System.out.println(String.format("%s：收看夏普电视上的第 %s 套节目", remoteControlName, channel));
    }
}
