package com.siwuxie095.forme.designpattern.category.chapter14th.example11th;

/**
 * 中介者
 *
 * @author Jiajing Li
 * @date 2019-11-11 20:15:35
 */
class Mediator {

    void onEvent(EventType eventType) {
        if (eventType == EventType.ALARM_EVENT) {
            checkCalendar();
            startCoffee();
        } else if (eventType == EventType.CALENDAR_EVENT) {
            checkDayOfWeek();
            doCoffee();
            doAlarm();
        } else if (eventType == EventType.COFFEE_EVENT) {
            checkCalendar();
            checkAlarm();
        }
    }

    private void checkCalendar() {
    }

    private void startCoffee() {
    }

    private void checkDayOfWeek() {
    }

    private void doCoffee() {
    }

    private void doAlarm() {
    }

    private void checkAlarm() {
    }
}
