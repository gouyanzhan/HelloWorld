package com.siwuxie095.forme.designpattern.summary.pattern2nd.observer.example1st;

/**
 * 主题
 *
 * @author Jiajing Li
 * @date 2019-08-12 23:19:00
 */
interface Subject {

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

