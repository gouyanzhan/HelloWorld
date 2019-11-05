package com.siwuxie095.forme.designpattern.category.chapter7th.example8th;

/**
 * 第三个家
 *
 * @author Jiajing Li
 * @date 2019-11-05 00:07:22
 */
public class House3rd {

    WeatherStation station;

    public House3rd(WeatherStation station) {
        this.station = station;
    }

    float getTemperature() {
        return station.getThermometer().getTemperature();
    }

}
