package com.gouyanzhan.assignment.assign003;

/**
 * @author Yanzhan Gou
 * @date 2019-06-15 21:29:21
 */
public class Display {
    public static void main(String[] args){
    Person z = new Person("缑延展",22);
        System.out.println(z.name + "的年龄为" + z.age);
    }
}

//11、定义一个类该类有一个私有成员变量通过构造方法将其进行赋初值并提供该成员的getXXX()和setXXX()方法。