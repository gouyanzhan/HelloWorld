package com.gouyanzhan.assignment.assign;

/**
 * @author Yanzhan Gou
 * @date 2019-05-18 12:33:19
 */
public class Rectangle {
    int a;
    int b;
    int perimeter;
    int area;
    public void perimeter(int a,int b){
        perimeter = 2*(a + b);
        System.out.println("长方形的周长为:" + perimeter);
    }
    public void area(int a,int b){
        area = a * b;
        System.out.println("长方形的面积为：" + area);
    }
}
