package com.siwuxie095.forme.designpattern.category.chapter2nd.example4th;

import java.util.Observable;
import java.util.Observer;

/**
 * 气象统计布告
 *
 * @author Jiajing Li
 * @date 2019-08-11 17:14:00
 */
class StatisticsDisplay implements Observer, DisplayElement {

    private Observable observable;

    private float temperature;

    private float humidity;

    private float pressure;

    StatisticsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) observable;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Statistics: " + temperature
                + "F degrees and " + humidity + "% humidity and "
                + pressure + " pressure");
    }
}
