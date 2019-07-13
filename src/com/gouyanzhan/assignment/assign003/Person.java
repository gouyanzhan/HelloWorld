package com.gouyanzhan.assignment.assign003;

/**
 * @author Yanzhan Gou
 * @date 2019-06-14 18:01:29
 */
public class Person {
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void setname(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void Display(){
        System.out.println("姓名："+getName()+" 年龄："+getAge());
    }

}

//10、编写Java程序用于显示人的姓名和年龄。 定义一个人类Person该类中应该有两个私有属性姓名name和年龄age。定义构造方法用来初始化数据成员。
// 再定义显示display方法将姓名和年龄打印出来。 在main方法中创建人类的实例然后将信息显示。

//11、定义一个类该类有一个私有成员变量通过构造方法将其进行赋初值并提供该成员的getXXX()和setXXX()方法。