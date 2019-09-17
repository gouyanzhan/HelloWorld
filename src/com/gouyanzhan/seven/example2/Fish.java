package com.gouyanzhan.seven.example2;

/**
 * @author Yanzhan Gou
 * @date 2019-09-15 19:25:25
 */
class Fish implements Animal{
    String name;
    public Fish(String nm){
        name = nm;
    }
    @Override
    public void sleep() {
        System.out.println(name + "在睁着眼睛睡觉");

    }

    @Override
    public void eat() {
        System.out.println(name + "在吃水草");
    }

    @Override
    public void breath() {
        System.out.println(name + "用腮呼吸");
    }
}
