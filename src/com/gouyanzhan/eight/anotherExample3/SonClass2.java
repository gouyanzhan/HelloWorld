package com.gouyanzhan.eight.anotherExample3;

import com.gouyanzhan.eight.example2.FatherClass;

/**
 * @author Yanzhan Gou
 * @date 2019-08-05 13:59:07
 */
public class SonClass2 extends FatherClass {
    void print(){
        SonClass2 son = new SonClass2();
        System.out.println("在子类的方法中：");
        System.out.println(son.str1);
    }
}
