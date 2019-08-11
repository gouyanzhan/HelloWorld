package com.siwuxie095.forme.designpattern.category.chapter2nd.example4th;

import java.util.Observable;

/**
 * 气象站的天气数据
 *
 * @author Jiajing Li
 * @date 2019-08-11 16:39:01
 */
class WeatherData extends Observable {

    private float temperature;

    private float humidity;

    private float pressure;

    WeatherData() {
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        // 这里是 拉模式
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
