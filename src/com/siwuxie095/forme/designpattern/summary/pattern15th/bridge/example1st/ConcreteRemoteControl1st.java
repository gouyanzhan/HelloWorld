package com.siwuxie095.forme.designpattern.summary.pattern15th.bridge.example1st;

/**
 * 一号具体遥控器
 *
 * @author Jiajing Li
 * @date 2019-11-11 14:39:28
 */
class ConcreteRemoteControl1st extends RemoteControl {

    ConcreteRemoteControl1st(TV tv) {
        this.tv = tv;
    }

    @Override
    void on() {
        tv.on();
    }

    @Override
    void off() {
        tv.off();
    }

    @Override
    void previousChannel() {
        setChannel(channel - 1);
    }

    @Override
    void nextChannel() {
        setChannel(channel + 1);
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        tv.tuneChannel(this.getClass().getSimpleName(), channel);
    }
}
