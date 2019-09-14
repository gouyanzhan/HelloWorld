package com.siwuxie095.forme.designpattern.category.chapter2nd.example3rd;

/**
 * 主题
 *
 * @author Jiajing Li
 * @date 2019-08-11 15:45:42
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
