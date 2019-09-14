package com.siwuxie095.forme.designpattern.category.chapter2nd.example3rd;

import java.util.ArrayList;

/**
 * 气象站的天气数据
 *
 * @author Jiajing Li
 * @date 2019-08-11 15:52:19
 */
class WeatherData implements Subject {

    /**
     * 观察者列表
     */
    private ArrayList<Observer> observerList;
    /**
     * 温度
     */
    private float temperature;
    /**
     * 湿度
     */
    private float humidity;
    /**
     * 气压
     */
    private float pressure;

    WeatherData() {
        observerList = new ArrayList<>();
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
        for (Observer observer : observerList) {
            observer.update(temperature, humidity, pressure);
        }
    }

    /**
     * 测量结果变化，通知观察者
     */
    private void measurementsChanged() {
        notifyObservers();
    }

    /**
     * 设置测量结果
     */
    void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
