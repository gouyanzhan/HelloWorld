package com.gouyanzhan.assignment.assign001;

/**
 * @author Yanzhan Gou
 * @date 2019-05-20 15:49:31
 */
public class Circle {
    private double pi = 3.14;
    double s;
    public void area(double r){
        s = pi * r * r;
        System.out.println("圆的面积为：" + s);
    }

}

//5、定义一类圆，求圆的周长和面积