package com.siwuxie095.foryou.clazz;

/**
 * @author Jiajing Li
 * @date 2019-02-28 22:27:56
 */
public class PassByValue {

    /**
     * 注意：Java 中的参数传递只有值传递！！！
     *
     * 有一种混淆的说法是错误的：Java 中的参数传递，分为值传递（传值）和引用传递（传地址）。
     */
    public void passByValue(int val) {
        val = val + 100;
        System.out.println("val in passByValue = " + val);
    }

    public void passByValue(String val) {
        val = val + " - gyz";
        System.out.println("val in passByValue = " + val);
    }

    public void passByValue(Human human) {
         // 看下面一行注释与否的区别
        //human = new Human();
        human.name = "缑延展";
        System.out.println("human.name in passByValue = " + human.name);
    }

}
