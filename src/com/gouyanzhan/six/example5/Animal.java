package com.gouyanzhan.six.example5;

/**
 * @author Yanzhan Gou
 * @date 2019-07-21 16:41:22
 */
abstract class Animal {
    String type;
    String name;
    int age;
    int weight;
    void eat(){
        System.out.println("动物爱吃饭");
    }
    abstract void breath();
    void sleep(){
        System.out.println("动物在睡觉");
    }
}
