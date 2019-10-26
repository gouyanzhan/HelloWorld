package com.siwuxie095.foryou.enumdemo;

/**
 * @author Yanzhan Gou
 * @date 2019-10-26 14:31:54
 */
public class Main {

    public static void main(String[] args) {
       print(WeekDays.MONDAY);
    }

    private static void print(WeekDays weekDays) {
        if (WeekDays.MONDAY == weekDays) {
            System.out.println(weekDays.getKey());
            System.out.println(weekDays.getValue());
            System.out.println(weekDays.getDesc());
        } else if (WeekDays.TUESDAY == weekDays) {
            System.out.println(weekDays.getDesc());
        }
    }



}
