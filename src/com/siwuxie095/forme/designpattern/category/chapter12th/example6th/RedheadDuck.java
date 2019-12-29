package com.siwuxie095.forme.designpattern.category.chapter12th.example6th;

/**
 * 红头鸭
 *
 * @author Jiajing Li
 * @date 2019-11-10 09:16:24
 */
class RedheadDuck implements Quackable {

    private QuackObservable quackObservable;

    RedheadDuck() {
        quackObservable = new QuackObservable(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack");
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
