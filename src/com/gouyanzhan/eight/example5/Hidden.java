package com.gouyanzhan.eight.example5;

public class Hidden {
    public static void main(String[] args){
        //创建父类对象
        Father father = new Father();
        //创建子类对象
        Son son = new Son();
        //分别访问它们的成员变量
        System.out.println("父类对象访问Str：");
        System.out.println(father.str);
        System.out.println("子类对象访问Str：");

    }

}
