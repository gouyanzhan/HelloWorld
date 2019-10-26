package com.siwuxie095.forme.designpattern.summary.pattern6th.singleton.example2nd;

/**
 * 单例类
 *
 * @author Jiajing Li
 * @date 2019-10-22 17:48:28
 */
class Singleton {

    /**
     * 利用一个静态变量记录 Singleton 类的唯一实例
     */
    private static Singleton uniqueInstance;

    /**
     * 私有构造器：只有 Singleton 类内才可以调用构造器
     */
    private Singleton() {}

    /**
     * 实例化对象，并返回该实例
     *
     * 使用 synchronized 关键字，使之变成同步方法
     */
    public static synchronized Singleton getInstance() {
        /*
         * uniqueInstance 为空，表示还没有创建实例，此时利用私有构造器产生一个
         * Singleton 实例，并赋值到 uniqueInstance 静态变量中。
         *
         * 值得注意的是，如果不需要该实例，它就永远不会产生。
         *
         * 即 延迟实例化（lazy instantiaze）。
         *
         * uniqueInstance 不为空，表示之间已经创建过对象，直接跳转到 return。
         */
        if (null == uniqueInstance) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }


    // other useful methods ...

    public void doSomething() {
        System.out.println("do something ...");
    }

}
