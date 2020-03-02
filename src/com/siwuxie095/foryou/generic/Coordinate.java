package com.siwuxie095.foryou.generic;

/**
 * @author Yanzhan Gou
 * @date 2019-11-09 15:24:45
 */
public class Coordinate<T> {

    T xCoordinate;

    T yCoordinate;

    public Coordinate(T xCoordinate, T yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public T getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(T xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public T getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(T yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    void print() {
        System.out.println("横坐标：" + xCoordinate);
        System.out.println("纵坐标：" + yCoordinate);
    }

}
