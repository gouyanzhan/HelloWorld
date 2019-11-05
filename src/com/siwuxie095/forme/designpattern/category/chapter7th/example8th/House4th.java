package com.siwuxie095.forme.designpattern.category.chapter7th.example8th;

/**
 * 第四个家
 *
 * @author Jiajing Li
 * @date 2019-11-05 00:07:22
 */
public class House4th {

    WeatherStation station;

    public House4th(WeatherStation station) {
        this.station = station;
    }

    float getTemperature() {
        Thermometer thermometer = station.getThermometer();
        return getTemperatureHelper(thermometer);
    }

    private float getTemperatureHelper(Thermometer thermometer) {
        return thermometer.getTemperature();
    }

}
