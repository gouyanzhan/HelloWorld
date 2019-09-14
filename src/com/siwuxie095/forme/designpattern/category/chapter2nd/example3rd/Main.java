package com.siwuxie095.forme.designpattern.category.chapter2nd.example3rd;

/**
 * @author Jiajing Li
 * @date 2019-08-11 16:22:59
 */
public class Main {
    /**
     * 观察者模式中：更偏向于由主题推，而不是由观察者拉。
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
