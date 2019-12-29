package com.siwuxie095.forme.designpattern.category.chapter14th.example1st;

/**
 * 二号具体遥控器
 *
 * @author Jiajing Li
 * @date 2019-11-11 14:39:28
 */
class ConcreteRemoteControl2nd extends RemoteControl {

    ConcreteRemoteControl2nd(TV tv) {
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
