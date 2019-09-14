package com.siwuxie095.forme.designpattern.category.chapter2nd.example4th;

import java.util.Observable;
import java.util.Observer;

/**
 * 目前状况布告
 *
 * @author Jiajing Li
 * @date 2019-08-11 17:07:39
 */
class CurrentConditionsDisplay implements Observer, DisplayElement {

    private Observable observable;

    private float temperature;

    private float humidity;

    CurrentConditionsDisplay(Observable observable) {
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
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity"
                + "\nAvg/Max/Min temperature = " + temperature);
    }

}
