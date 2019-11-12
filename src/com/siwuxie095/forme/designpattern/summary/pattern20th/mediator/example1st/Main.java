package com.siwuxie095.forme.designpattern.summary.pattern20th.mediator.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-11 19:37:18
 */
public class Main {

    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Alarm alarm = new Alarm(mediator);
        alarm.onEvent();
    }

}
