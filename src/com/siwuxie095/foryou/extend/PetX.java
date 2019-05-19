package com.siwuxie095.foryou.extend;

/**
 * @author Jiajing Li
 * @date 2019-03-18 15:53:43
 */
public abstract class PetX {

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

    public abstract void talk();

    public abstract void print();

}
