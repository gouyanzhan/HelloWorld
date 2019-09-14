package com.siwuxie095.forme.designpattern.category.chapter2nd.example2nd;

import java.util.ArrayList;

/**
 * 具体主题
 *
 * @author Jiajing Li
 * @date 2019-08-11 14:08:01
 */
class ConcreteSubject implements Subject {

    /**
     * 观察者列表
     */
    private ArrayList<Observer> observerList;

    /**
     * 状态
     */
    private String state;

    public ConcreteSubject() {
        observerList = new ArrayList<>();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
        // 或者
        //int i = observerList.indexOf(observer);
        //if (i >= 0) {
        //    observerList.remove(i);
        //}
    }

    @Override
    public void notifyObservers() {
        String state = getState();
        for (Observer observer : observerList) {
            observer.update(state);
        }
    }


}
