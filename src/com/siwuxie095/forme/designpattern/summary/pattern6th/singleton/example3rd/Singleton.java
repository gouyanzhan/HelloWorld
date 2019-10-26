package com.siwuxie095.forme.designpattern.summary.pattern6th.singleton.example3rd;

/**
 * 单例类
 *
 * @author Jiajing Li
 * @date 2019-10-22 17:48:28
 */
class Singleton {

    /**
     * 利用一个静态变量记录 Singleton 类的唯一实例
     *
     * 在静态初始化时，就创建了实例，可以保证线程安全
     */
    private static Singleton uniqueInstance = new Singleton();

    /**
     * 私有构造器：只有 Singleton 类内才可以调用构造器
     */
    private Singleton() {}

    /**
     * 实例化对象，并返回该实例
     */
    public static Singleton getInstance() {
        return uniqueInstance;
    }


    // other useful methods ...

    public void doSomething() {
        System.out.println("do something ...");
    }

}
