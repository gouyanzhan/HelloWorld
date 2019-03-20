package com.siwuxie095.foryou.extend;

/**
 * @author Jiajing Li
 * @date 2019-03-18 15:54:16
 */
public class DogX extends PetX {

    public String dogType;

    @Override
    public void talk() {
        System.out.println("宠物" + type + "：" + name + "，属于" + dogType + "，正在汪汪叫...");
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    public void wagTail() {
        System.out.println(dogType + "：" + name + "，正在摇尾巴...");
    }

    @Override
    public String toString() {
        return "DogX{" +
                "dogType='" + dogType + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                '}';
    }
}
