package com.gouyanzhan.clazz;

/**
 * @author Yanzhan Gou
 * @date 2019-03-09 17:06:29
 */
public class Human {
    //声明各类变量来描述类的属性
    String name;
    String sex;
    int age;
    String addr;

    void work() {
        System.out.println("我在工作");
    }

    void eat() {
        System.out.println("我在吃饭");
    }

    //定义一个方法，返回值为String类型
    String getState(int time) {
        String state = null;
        if (time >= 0 && 24 >= time) {
            if (time > 8 && time < 17) {
                state = "我在工作";
            } else if (time > 17 && time < 22) {
                state = "我在学习";
            } else if (time > 22 || time < 7) {
                state = "我在睡觉";
            } else {
                state = "错误的时间";
            }
        }
        return state;
    }



}
