package com.siwuxie095.forme.designpattern.category.chapter14th.example11th;

/**
 * 闹钟
 *
 * @author Jiajing Li
 * @date 2019-11-11 19:44:46
 */
class Alarm {

    private Mediator mediator;

    Alarm(Mediator mediator) {
        this.mediator = mediator;
    }

    void onEvent() {
        mediator.onEvent(EventType.ALARM_EVENT);
    }


}
