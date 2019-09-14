package com.siwuxie095.forme.designpattern.category.chapter2nd.example1st;

/**
 * @author Jiajing Li
 * @date 2019-08-11 13:50:35
 */
public class Main {

    /**
     * 说明：
     * 1、气象站拥有天气数据 WeatherData；
     * 2、有三个使用天气数据的布告板：目前状况布告、气象统计布告、天气预报布告；
     * 3、一旦天气数据有了新的测量，这些布告必须马上更新；
     *
     * 本例实际上是一个错误示范，它有如下问题：
     * 1、是针对具体实现编程，而非针对接口；
     * 2、对于每个新的布告板，都得修改代码；
     * 3、无法在运行时动态的增加或删除布告板；
     * 4、尚未封装改变的部分；
     */
    public static void main(String[] args) {

    }

}
