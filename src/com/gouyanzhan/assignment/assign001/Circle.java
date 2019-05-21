package com.gouyanzhan.assignment.assign001;

/**
 * @author Yanzhan Gou
 * @date 2019-05-20 15:49:31
 */
public class Circle {
    double r;
    double s;
    public void area(double r){
        s = 3.14 * r * r;
        System.out.println("圆的面积为：" + s);
    }

}
