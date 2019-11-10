package com.siwuxie095.forme.designpattern.category.chapter12th.example7th;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 可观察的鸭子（主题/被观察者/可观察者）
 *
 * 辅助类
 *
 * @author Jiajing Li
 * @date 2019-11-10 11:23:42
 */
class QuackObservable implements Observable {

    /*
     * QuackObservable 实现了所有必要的功能。只要把它插进一个类，
     * 就可以让该类将工作委托给 QuackObservable。
     */

    private List<Observer> observers = new ArrayList<>();

    private Observable duck;

    /**
     * 构造器中传进了 Observable。当通知发生时，就把此对象传过去，
     * 好让观察者知道是哪个对象在呱呱叫。
     */
    QuackObservable(Observable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator iterator = observers.iterator();
        while (iterator.hasNext()) {
            Observer observer = (Observer) iterator.next();
            observer.update(duck);
        }
    }
}
