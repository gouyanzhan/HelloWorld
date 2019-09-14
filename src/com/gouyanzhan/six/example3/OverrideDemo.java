package com.gouyanzhan.six.example3;


public class OverrideDemo {
    public static void main(String[] args){
        //声明三个不同的对象
        Tiger tiger = new Tiger();
        Fish fish  = new Fish();
        Dog dog = new Dog();
        //都调用breath方法
        tiger.breath();
        System.out.println();
        tiger.tigerRun();
        System.out.println();
        fish.breath();
        //fish.swim();
        //fish.sleep();
        //fish.eat();
        //dog.breath();
    }


}
