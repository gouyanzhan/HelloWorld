package com.siwuxie095.forme.designpattern.summary.pattern16th.builder.example1st;

/**
 * 假期计划表
 *
 * @author Jiajing Li
 * @date 2019-11-11 15:45:27
 */
class VacationPlanner {

    /**
     * 第几天
     */
    private int day;

    /**
     * 旅馆
     */
    private String hotel;

    /**
     * 特殊活动
     */
    private String specialEvent;

    /**
     * 门票
     */
    private String ticket;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getSpecialEvent() {
        return specialEvent;
    }

    public void setSpecialEvent(String specialEvent) {
        this.specialEvent = specialEvent;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "VacationPlanner{" +
                "day=" + day +
                ", hotel='" + hotel + '\'' +
                ", specialEvent='" + specialEvent + '\'' +
                ", ticket='" + ticket + '\'' +
                '}';
    }
}
