package com.siwuxie095.foryou.extend;

/**
 * @author Jiajing Li
 * @date 2019-03-18 15:53:59
 */
public class CatX extends PetX {

    public String catType;

    @Override
    public void talk() {
        System.out.println("宠物" + type + "：" + name + "，属于"+ catType +"，正在喵喵叫...");
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    public void climbTree() {
        System.out.println(catType + "：" + name + "，正在爬树...");
    }

    @Override
    public String toString() {
        return "CatX{" +
                "catType='" + catType + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                '}';
    }

}
