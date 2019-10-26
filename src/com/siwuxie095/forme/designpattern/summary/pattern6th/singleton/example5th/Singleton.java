package com.siwuxie095.forme.designpattern.summary.pattern6th.singleton.example5th;

/**
 * 单例类
 *
 * @author Jiajing Li
 * @date 2019-10-22 17:48:28
 */
class Singleton {

    /**
     * 私有构造器：只有 Singleton 类内才可以调用构造器
     */
    private Singleton() {}

    /**
     * 实例化对象，并返回该实例
     *
     * 只有第一次调用 getInstance()，JVM 才加载 Inner 并初始化 UNIQUE_INSTANCE，
     * 只有一个线程可以获得对象的初始化锁，其他线程无法进行初始化，保证对象的唯一性。
     */
    public static Singleton getInstance() {
        return Inner.UNIQUE_INSTANCE;
    }


    // other useful methods ...

    public void doSomething() {
        System.out.println("do something ...");
    }

    /**
     * 静态内部类
     */
    private static class Inner {
        private static final Singleton UNIQUE_INSTANCE = new Singleton();
    }

}
