package com.siwuxie095.forme.designpattern.summary.pattern20th.mediator.example1st;

/**
 * 咖啡壶
 *
 * @author Jiajing Li
 * @date 2019-11-11 19:45:04
 */
class CoffeePot {

    private Mediator mediator;

    CoffeePot(Mediator mediator) {
        this.mediator = mediator;
    }

    void onEvent() {
        mediator.onEvent(EventType.COFFEE_EVENT);
    }
}
