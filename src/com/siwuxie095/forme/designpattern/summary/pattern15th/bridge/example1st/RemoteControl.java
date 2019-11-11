package com.siwuxie095.forme.designpattern.summary.pattern15th.bridge.example1st;

/**
 * 遥控器
 *
 * @author Jiajing Li
 * @date 2019-11-11 14:27:11
 */
abstract class RemoteControl {

    /**
     * 持有对电视的引用
     */
    protected TV tv;

    /**
     * 频道
     */
    int channel;

    /**
     * 打开电视
     */
    abstract void on();

    /**
     * 关闭电视
     */
    abstract void off();

    /**
     * 上一个频道
     */
    abstract void previousChannel();

    /**
     * 下一个频道
     */
    abstract void nextChannel();

    abstract void setChannel(int channel);

}
