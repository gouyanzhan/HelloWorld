package com.siwuxie095.foryou.extend;

/**
 * @author Jiajing Li
 * @date 2019-03-18 09:32:00
 */
public class Dog extends Pet {

    public String dogType;

    @Override
    public void talk() {
        System.out.println("宠物" + type + "：" + name + "，属于" + dogType + "，正在汪汪叫...");
    }

    public void wagTail() {
        System.out.println(dogType + "：" + name + "，正在摇尾巴...");
    }

}
