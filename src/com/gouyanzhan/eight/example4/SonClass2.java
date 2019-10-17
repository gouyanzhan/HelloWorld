package com.gouyanzhan.eight.example4;

/**
 * @author Yanzhan Gou
 * @date 2019-10-17 17:14:27
 */
public class SonClass2 extends FatherClass2{
    void print(){
        SonClass2 son = new SonClass2();
        System.out.println("在子类的方法中：");
        //该语句编译错误
        System.out.println(son.str3);
    }

}
