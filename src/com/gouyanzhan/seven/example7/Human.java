package com.gouyanzhan.seven.example7;

/**
 * @author Yanzhan Gou
 * @date 2019-09-17 20:55:38
 */
class Human {
    String name;
    String sex;
    int age;
    String addr;
    Human(String name,String sex,int age,String addr){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.addr = addr;
    }
    void work(){
        System.out.println("我在工作");
    }
    void eat(){
        System.out.println("我在吃饭");
    }
}
