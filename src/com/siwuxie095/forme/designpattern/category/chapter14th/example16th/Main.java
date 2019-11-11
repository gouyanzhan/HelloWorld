package com.siwuxie095.forme.designpattern.category.chapter14th.example16th;

/**
 * @author Jiajing Li
 * @date 2019-11-11 22:48:08
 */
public class Main {

    /**
     * 原型模式
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype realizetype = new Realizetype();
        Prototype realizetype0 = realizetype.clone();
        System.out.println(realizetype0.getClass().getSimpleName());
    }

}
