package com.siwuxie095.forme.designpattern.summary.pattern20th.mediator.example1st;

/**
 * 日历
 *
 * @author Jiajing Li
 * @date 2019-11-11 19:45:55
 */
class Calendar {

    private Mediator mediator;

    Calendar(Mediator mediator) {
        this.mediator = mediator;
    }

    void onEvent() {
        mediator.onEvent(EventType.CALENDAR_EVENT);
    }


}
