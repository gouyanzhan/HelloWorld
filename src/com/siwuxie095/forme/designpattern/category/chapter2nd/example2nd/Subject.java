package com.siwuxie095.forme.designpattern.category.chapter2nd.example2nd;

/**
 * 主题
 *
 * @author Jiajing Li
 * @date 2019-08-11 14:05:58
 */
interface Subject {

    /**
     * 注册观察者（注册）
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者（撤销）
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者（在状态变更时，更新所有当前观察者）
     */
    void notifyObservers();
}
