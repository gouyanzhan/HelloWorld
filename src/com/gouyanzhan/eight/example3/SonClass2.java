package com.gouyanzhan.eight.example3;

/**
 * @author Yanzhan Gou
 * @date 2019-10-17 17:10:07
 */
public class SonClass2 extends FatherClass{
    void print(){
        SonClass2 son = new SonClass2();
        System.out.println("在子类的方法中：");
        System.out.println(son.str1);
    }
}
