package com.gouyanzhan.six.example4;

public class DynamicMethodDemo {
    public static void main(String[] args){
        Animal []animal = new Animal[3];
        //创建不同的对象，但是都存入Animal的引用中
        animal[0] = new Animal();
        animal[1] = new Tiger();
        animal[2] = new Fish();
        animal[1].breath();
        animal[2].breath();
    }
}
