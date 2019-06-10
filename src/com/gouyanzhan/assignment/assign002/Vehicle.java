package com.gouyanzhan.assignment.assign002;

/**
 * @author Yanzhan Gou
 * @date 2019-06-01 11:59:17
 */
public class Vehicle {
    double speed;
    double size;
    public Vehicle(double a,double b){
        speed = a;
        size = b;
    }
    public void move(){
        System.out.println("移动");
    }
    public void setSpeed(double speed){
        System.out.println("速度为" + speed);
    }
    public void setSize(double size){
        System.out.println("体积为" + size);
    }
    public void speedUp(){
        speed = speed + 10;
        System.out.println("加速后的速度"+speed);
    }
    public void speedDown(){
        speed = speed - 10;
        System.out.println("减速后的速度"+speed);
    }

}
