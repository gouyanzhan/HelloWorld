package com.siwuxie095.forme.test.test040;

/**
 * @author Jiajing Li
 * @date 2020-06-18 13:40:06
 */
public class Main {

    /**
     * 说明的问题：
     * 1、获取一个类中定义的泛型类型。
     *
     * （之所以定义为一个抽象类，是为了说明必须要从子类中去获取泛型类型。其实任意类都可以，只要从子类去获取泛型类型即可）
     */
    public static void main(String[] args) {
        Generic<Integer> generic = new Generic<Integer>(){};
        System.out.println(generic.getGenericClass());
    }




}
