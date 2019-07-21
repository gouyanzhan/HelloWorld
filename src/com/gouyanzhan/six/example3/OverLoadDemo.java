package com.gouyanzhan.six.example3;


public class OverLoadDemo {
    public static void main(String[] args){
        //声明三个不同的对象
        Tiger tiger = new Tiger();
        Fish fish  = new Fish();
        Dog dog = new Dog();
        //都调用breath方法
        tiger.breath();
        fish.breath();
        dog.breath();
    }


}
