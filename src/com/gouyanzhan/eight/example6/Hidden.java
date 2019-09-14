package com.gouyanzhan.eight.example6;

/**
 * @author Yanzhan Gou
 * @date 2019-08-05 14:36:29
 */
public class Hidden {
    public static void main(String[] args){
        //创建子类对象
        Son son = new Son();
        System.out.println("调用隐藏的父类成员变量");
        //调用子类的方法
        son.show();
    }
}
