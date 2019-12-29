package com.siwuxie095.forme.designpattern.category.chapter7th.example8th;

/**
 * 第二个家
 *
 * @author Jiajing Li
 * @date 2019-11-05 00:07:22
 */
public class House2nd {

    WeatherStation station;

    public House2nd(WeatherStation station) {
        this.station = station;
    }

    float getTemperature() {
        Thermometer thermometer = station.getThermometer();
        return thermometer.getTemperature();
    }

}
