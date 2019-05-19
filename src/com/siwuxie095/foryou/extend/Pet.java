package com.siwuxie095.foryou.extend;

/**
 * @author Jiajing Li
 * @date 2019-03-18 09:20:14
 */
public class Pet {

    public String name;

    public String sex;

    public int age;

    public String type;

    public double weight;

    public void eat() {
        System.out.println("宠物" + type + "：" + name + "，正在吃饭...");
    }

    public void play() {
        System.out.println("宠物" + type + "：" + name + "，正在玩耍...");
    }

    public void sleep() {
        System.out.println("宠物" + type + "：" + name + "，正在睡觉...");
    }

    public void talk() {
        System.out.println("宠物" + type + "：" + name + "，正在说话...");
    }

    public void print() {
        System.out.println("姓名：" + name);
        System.out.println("性别：" + sex);
        System.out.println("年龄：" + age);
        System.out.println("种类：" + type);
        System.out.println("体重：" + weight);
    }

}
