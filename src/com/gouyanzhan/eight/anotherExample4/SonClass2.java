package com.gouyanzhan.eight.anotherExample4;

import com.gouyanzhan.eight.example4.FatherClass2;

/**
 * @author Yanzhan Gou
 * @date 2019-08-05 14:10:49
 */
public class SonClass2 extends FatherClass2 {
void print(){
    SonClass2 son = new SonClass2();
    System.out.println("在子类的方法中：");
}
}

