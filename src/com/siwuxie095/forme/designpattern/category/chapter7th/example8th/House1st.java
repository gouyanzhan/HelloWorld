package com.siwuxie095.forme.designpattern.category.chapter7th.example8th;

/**
 * 第一个家
 *
 * @author Jiajing Li
 * @date 2019-11-05 00:07:22
 */
public class House1st {


    WeatherStation station;

    public House1st(WeatherStation station) {
        this.station = station;
    }

    float getTemperature() {
        return station.getTemperature();
    }

}
