package com.gouyanzhan.assignment.assign002;

/**
 * @author Yanzhan Gou
 * @date 2019-06-10 20:35:13
 */
public class MyTime {
    private int hour;
    private int minute;
    private int second;
    public MyTime(int hour,int minute,int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public void setHour(int hour){
        this.hour = hour;
    }
    public void setMinute(int minute){
        this.minute = minute;
    }
    public void setSecond(int second){
        this.second = second;
    }

}
