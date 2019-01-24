package com.siwuxie095.foryou.clazz;

/**
 * 关于构造方法
 *
 * @author Jiajing Li
 * @date 2019-01-22 15:18:55
 */
public class Constructor {

    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 爱好
     */
    private String hobby;

    /**
     * 隐式的构造方法就长这个样
     */
    public Constructor() {

    }

    /**
     * 以下是各种各样的构造方法
     */


    public Constructor(String name) {
        this.name = name;
    }

    public Constructor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Constructor(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Constructor(String name, int age, String sex, String hobby) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
    }

    public void print() {
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
        System.out.println("性别：" + sex);
        System.out.println("爱好：" + hobby);
        System.out.println("-------------------");
    }
}
