package com.siwuxie095.forme.designpattern.category.chapter14th.example3rd;

/**
 * 抽象生成器
 *
 * @author Jiajing Li
 * @date 2019-11-11 15:49:17
 */
abstract class AbstractBuilder {

    abstract void buildDay(int day);

    abstract void addHotel(String hotel);

    abstract void addSpecialEvent(String specialEvent);

    abstract void addTicket(String ticket);

    abstract VacationPlanner getVacationPlanner();

}
