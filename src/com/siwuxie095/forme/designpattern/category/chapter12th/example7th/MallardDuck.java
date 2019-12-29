package com.siwuxie095.forme.designpattern.category.chapter12th.example7th;

/**
 * 绿头鸭
 *
 * @author Jiajing Li
 * @date 2019-11-10 09:15:36
 */
class MallardDuck implements Quackable {

    private QuackObservable quackObservable;

    public MallardDuck() {
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
