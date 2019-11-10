package com.siwuxie095.forme.designpattern.category.chapter12th.example7th;

/**
 * 橡皮鸭
 *
 * @author Jiajing Li
 * @date 2019-11-10 09:19:32
 */
public class RubberDuck implements Quackable {

    private QuackObservable quackObservable;

    RubberDuck() {
        quackObservable = new QuackObservable(this);
    }

    /**
     * 橡皮鸭呱呱叫时，其实声音是吱吱叫
     */
    @Override
    public void quack() {
        System.out.println("Squeak");
        notifyObservers();
    }

    /**
     * 委托给辅助类
     */
    @Override
    public void registerObserver(Observer observer) {
        quackObservable.registerObserver(observer);
    }

    /**
     * 委托给辅助类
     */
    @Override
    public void removeObserver(Observer observer) {
        quackObservable.removeObserver(observer);
    }

    /**
     * 委托给辅助类
     */
    @Override
    public void notifyObservers() {
        quackObservable.notifyObservers();
    }
}
