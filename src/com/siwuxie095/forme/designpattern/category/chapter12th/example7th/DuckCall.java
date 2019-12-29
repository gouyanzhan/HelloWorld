package com.siwuxie095.forme.designpattern.category.chapter12th.example7th;

/**
 * 鸭鸣器
 *
 * @author Jiajing Li
 * @date 2019-11-10 09:17:47
 */
class DuckCall implements Quackable {

    private QuackObservable quackObservable;

    DuckCall() {
        quackObservable = new QuackObservable(this);
    }

    /**
     * 鸭鸣器会呱呱叫，但听起来并不十分像真的鸭叫声
     */
    @Override
    public void quack() {
        System.out.println("Kwak");
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
