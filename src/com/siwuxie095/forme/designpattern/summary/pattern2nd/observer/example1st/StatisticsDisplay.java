package com.siwuxie095.forme.designpattern.summary.pattern2nd.observer.example1st;

/**
 * 气象统计布告
 *
 * @author Jiajing Li
 * @date 2019-08-12 23:24:28
 */
class StatisticsDisplay implements Observer, DisplayElement {

    private float temperature;

    private float humidity;

    private float pressure;

    private Subject weatherData;

    StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Statistics: " + temperature
                + "F degrees and " + humidity + "% humidity and "
                + pressure + " pressure");
    }

}

