package com.siwuxie095.forme.test.test041;

/**
 * @author Jiajing Li
 * @date 2020-06-24 10:10:47
 */
public class Main {

    /**
     * 说明的问题：
     * 1、获取一个接口中定义的泛型类型。
     *
     * （之所以定义为一个接口，是为了说明必须要从实现类中去获取泛型类型。）
     */
    public static void main(String[] args) {
        Generic<String> generic = new Generic<String>(){};
        System.out.println(generic.getGenericClass());
    }

}
