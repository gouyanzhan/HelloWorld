package com.gouyanzhan.assignment.assign;

/**
 * @author Yanzhan Gou
 * @date 2019-05-18 12:33:19
 */
public class Rectangle {
    public void perimeter(int a,int b){
        int perimeter;
        perimeter = 2*(a + b);
        System.out.println("长方形的周长为:" + perimeter);
    }
    public void area(int a,int b){
        int area;
        area = a * b;
        System.out.println("长方形的面积为：" + area);
    }
}
//2.定义一个长方形类,定义 求周长和面积的方法，进行测试。
