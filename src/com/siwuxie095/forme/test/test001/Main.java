package com.siwuxie095.forme.test.test001;

/**
 * 主类
 */
public class Main {
    /**
     * 说明的问题：
     *
     * 1、访问控制权限：public > protected > default > private （PS：什么都不写，即为 default）；
     *
     * 2、在继承时，只有 public 和 protected 的方法才能 100% 的被继承；
     *
     * 3、在继承时，default 的方法只有同包下的子类才能继承；
     *
     * 4、对于静态变量或静态方法，在继承时，不会被覆盖或重写，谁调用，就调用谁的，不管有没有强转。
     *    如：父类或父类对象只能调用父类中的静态变量或静态方法；
     *
     * 5、子类对象无法直接从父类对象强转过来，除非这个父类对象之前就已经是从子类对象强转过来的。
     */
    public static void main(String[] args) {
        SubTest.testStatic();
        BaseTest.testStatic();
        SubTest subTest = new SubTest();
        subTest.testStatic();

        BaseTest baseTest = new SubTest();
        baseTest.testStatic();
        SubTest subTest1 = (SubTest) baseTest;
        subTest1.testStatic();
    }
}
