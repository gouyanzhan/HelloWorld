package com.gouyanzhan.assignment.assign002;

/**
 * @author Yanzhan Gou
 * @date 2019-06-01 12:00:00
 */
public class VehicleTest {
    public static void main(String[] args){
        Vehicle z = new Vehicle(12,20);
        z.move();
        z.setSpeed(1);
        z.setSize(2);
        z.speedDown();
        z.speedUp();

    }


}
