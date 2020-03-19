package com.siwuxie095.forme.test.test023;

import java.lang.reflect.Field;

/**
 * @author Jiajing Li
 * @date 2020-03-19 14:38:20
 */
public class Main {

    /**
     * 说明的问题：
     * 1、对于反射，在判空的情况下，是否会抛异常。结论：会抛异常，所以要 try catch。
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        MyCase myCase = new MyCase();
        myCase.first = "1";
        myCase.second = "2";
        Field first = myCase.getClass().getField("first");
        if (null != first) {
            System.out.println(first.get(myCase).toString());
        }
        Field second = myCase.getClass().getField("second");
        if (null != second) {
            System.out.println(second.get(myCase).toString());
        }
        try {
            Field third = myCase.getClass().getField("third");
            if (null != third) {
                System.out.println(third.get(myCase).toString());
            }
        } catch (Exception e) {}

    }

}
