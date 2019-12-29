package com.siwuxie095.forme.designpattern.category.chapter7th.example8th;

/**
 * 气象站
 *
 * @author Jiajing Li
 * @date 2019-11-05 00:06:39
 */
class WeatherStation {

    private Thermometer thermometer;

    public WeatherStation(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    Thermometer getThermometer() {
        return thermometer;
    }

    float getTemperature() {
        return thermometer.getTemperature();
    }


}
