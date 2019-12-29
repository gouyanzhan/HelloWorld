package com.siwuxie095.forme.designpattern.category.chapter12th.example6th;

/**
 * 被观察者/可观察者/主题
 *
 * @author Jiajing Li
 * @date 2019-11-10 11:39:28
 */
interface Observable {

    /**
     * 注册观察者
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObservers();

}
