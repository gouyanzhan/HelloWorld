package com.siwuxie095.foryou.extend;

/**
 * @author Jiajing Li
 * @date 2019-03-18 09:20:23
 */
public class Cat extends Pet {

    public String catType;

    @Override
    public void talk() {
        System.out.println("宠物" + type + "：" + name + "，属于"+ catType +"，正在喵喵叫...");
    }

    public void climbTree() {
        System.out.println(catType + "：" + name + "，正在爬树...");
    }

}
