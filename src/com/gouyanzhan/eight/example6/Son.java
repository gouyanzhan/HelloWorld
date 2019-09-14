package com.gouyanzhan.eight.example6;

/**
 * @author Yanzhan Gou
 * @date 2019-08-05 14:36:20
 */
class Son extends Father{
    String str = "子类的Str成员变量";
    void show(){
        System.out.println(super.str);
    }
}
