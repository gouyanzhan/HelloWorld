package com.gouyanzhan.eight.example2;

/**
 * @author Yanzhan Gou
 * @date 2019-08-05 11:46:36
 */
class SonClass extends FatherClass{
    void print(){
        SonClass son = new SonClass();
        System.out.println("在子类的方法中：");
        //子类对象继承父类的属性str1
        System.out.println(son.str1);
    }
}
