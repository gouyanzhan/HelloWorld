package com.siwuxie095.forme.designpattern.summary.pattern2nd.observer.example1st;

/**
 * 天气预报布告
 *
 * @author Jiajing Li
 * @date 2019-08-12 23:25:55
 */
class ForecastDisplay implements Observer, DisplayElement {

    private float temperature;

    private float humidity;

    private Subject weatherData;

    ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Forecast: " + temperature
                + "F degrees and " + humidity + "% humidity"
                + "\nAvg/Max/Min temperature = " + temperature);
    }

}

