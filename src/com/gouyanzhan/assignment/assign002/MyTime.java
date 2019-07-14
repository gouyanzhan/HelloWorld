package com.gouyanzhan.assignment.assign002;


/**
 * @author Yanzhan Gou
 * @date 2019-06-10 20:35:13
 */
public class MyTime {
    private int hour;
    private int minute;
    private int second;
    public MyTime(int hour,int minute,int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public void setHour(int hour){
        this.hour = hour;
    }
    public int getHour(){
        return hour;
    }
    public void setMinute(int minute){
        this.minute = minute;
    }
    public int getMinute(){
        return minute;
    }
    public void setSecond(int second){
        this.second = second;
    }
    public int getSecond(){
        return second;
    }
    public void display(){
        System.out.println(hour+":"+minute+":"+second);
        System.out.println(getHour()+":"+getMinute()+":"+getSecond());
        System.out.println();
    }
    public void addSecond(int sec){
        this.second = this.second + sec;
        if (this.second > 60){
            int count = this.second/60;
            this.second = this.second % 60;
            addMinute(count);
        }
    }
    public void addMinute(int min){
        this.minute = this.minute +min;
        if (this.minute > 60){
            int count = this.minute/60;
            this.minute = this.minute % 60;
            addHour(count);
        }

    }
    public void addHour(int hour){
        this.hour = this.hour + hour;
        if (this.hour > 24){
            this.hour = this.hour % 24;
        }
    }
    public void subSecond(int sec){
        this.second = this.second -sec;
        if (this.second < 0){
           int count =  -(this.second / 60) + 1;
            this.second = this.second % 60 + 60;
            subMinute(count);
        }
    }
    public void subMinute(int min){
        this.minute = this.minute - min;
        if (this.minute < 0){
            int count =  -(this.second / 60) + 1;
            this.minute = this.minute % 60 + 60;
            subHour(count);
        }

    }
    public void subHour(int hour){
        this.hour = this.hour - hour;
        if (this.hour < 0){
            this.hour = this.hour % 24 + 24;

        }
    }

}

//8、在程序中经常要对时间进行操作但是并没有时间类型的数据。那么我们可以自己实现一个时间类来满足程序中的需要。 定义名为MyTime的类其中应有
// 三个整型成员时hour分minute秒second为了保证数据的安全性这三个成员变量应声明为私有。 为MyTime类定义构造方法以方便创建对象时初始化成员
// 变量。 再定义diaplay方法用于将时间信息打印出来。 为MyTime类添加以下方法 addSecond(int sec) addMinute(int min) addHour(int hou)
// subSecond(int sec) subMinute(int min) subHour(int hou) 分别对时、分、秒进行加减运算。