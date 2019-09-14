package com.siwuxie095.forme.designpattern.summary.pattern2nd.observer.example1st;

/**
 * @author Jiajing Li
 * @date 2019-08-12 23:26:59
 */
public class Main {

    /**
     * 自己实现的观察者模式
     *
     * 推模式（push）
     */
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        System.out.println();
        weatherData.setMeasurements(82, 70, 29.2f);
        System.out.println();
        weatherData.setMeasurements(78, 90, 29.2f);
    }

}
