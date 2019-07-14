package com.gouyanzhan.assignment.assign002;

/**
 * @author Yanzhan Gou
 * @date 2019-07-07 17:19:54
 */
public class MyTimeTest {
    public static void main(String[] args){
        MyTime time = new MyTime(17,23,12);
        time.display();
        time.subMinute(50);
        time.display();
    }

}
