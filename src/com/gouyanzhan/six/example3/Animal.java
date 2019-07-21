package com.gouyanzhan.six.example3;

/**
 * @author Yanzhan Gou
 * @date 2019-07-21 14:57:29
 */
class Animal{
    String type;      //种类
    String name;      //名称
    int age;          //年龄
    int weight;       //体重
    void eat(){
        System.out.println("动物爱吃饭");
    }
    void breath(){
        System.out.println("动物呼吸");
    }
    void sleep(){
        System.out.println("动物在睡觉");
    }
}
