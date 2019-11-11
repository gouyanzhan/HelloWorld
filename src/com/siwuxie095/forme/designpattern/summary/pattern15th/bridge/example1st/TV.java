package com.siwuxie095.forme.designpattern.summary.pattern15th.bridge.example1st;

/**
 * 电视
 *
 * @author Jiajing Li
 * @date 2019-11-11 14:21:03
 */
abstract class TV {

    /**
     * 打开电视
     */
    abstract void on();

    /**
     * 关闭电视
     */
    abstract void off();

    /**
     * 收看节目
     */
    abstract void tuneChannel(String remoteControlName, int channel);

}
