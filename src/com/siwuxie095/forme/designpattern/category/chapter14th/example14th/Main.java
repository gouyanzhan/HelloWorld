package com.siwuxie095.forme.designpattern.category.chapter14th.example14th;

/**
 * @author Jiajing Li
 * @date 2019-11-11 22:05:12
 */
public class Main {

    /**
     * 备忘录模式
     */
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("#1");
        originator.setState("#2");
        originator.setState("#3");

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());
        System.out.println(originator.getState());

        originator.setState("#4");
        originator.setState("#5");

        originator.restoreMemento(caretaker.getMemento());
        System.out.println(originator.getState());
    }

}
