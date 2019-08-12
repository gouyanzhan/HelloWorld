package com.siwuxie095.forme.designpattern.summary.pattern2nd.observer.example2nd;

import java.util.Observable;
import java.util.Observer;

/**
 * 天气预报布告
 *
 * @author Jiajing Li
 * @date 2019-08-12 23:41:05
 */
class ForecastDisplay implements Observer, DisplayElement {

    private Observable observable;

    private float temperature;

    private float humidity;

    ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) observable;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Forecast: " + temperature
                + "F degrees and " + humidity + "% humidity"
                + "\nAvg/Max/Min temperature = " + temperature);
    }
}

