package com.gouyanzhan.six.example4;

/**
 * @author Yanzhan Gou
 * @date 2019-07-21 15:54:00
 */ //Fish继承Animal类
class Fish extends Animal {
    String fishType;
    //Fish 自己的方法
    void swim() {
        System.out.println("鱼在游泳");
    }
    @Override
    void breath() {
        System.out.println("鱼是用腮呼吸的");
    }
}
//public class A {

//}